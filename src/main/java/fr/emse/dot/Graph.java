package fr.emse.dot;

import fr.emse.dot.parser.DotBaseListener;
import fr.emse.dot.parser.DotLexer;
import fr.emse.dot.parser.DotParser;
import fr.emse.eg.EG;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.vocabulary.RDF;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Data structure holding the abstract syntax tree of a DOT file
 */
public class Graph extends AttributedEntity {

    static class GraphBuilder extends DotBaseListener {

        private final Map<ParseTree, AttributedEntity> contexts = new HashMap<>();

        private Graph graph;

        @Override
        public void enterGraph(DotParser.GraphContext ctx) {
            Boolean isDigraph = ctx.graphType().getText().equals("digraph");
            graph = new Graph(isDigraph);
        }

        @Override
        public void enterAttrStmt(DotParser.AttrStmtContext ctx) {
            if (ctx.entityType().getText().equals("graph")) contexts.put(ctx.attrList().aList(), graph);
            // TODO else if 'node' or 'edge'
        }

        @Override
        public void enterNodeStmt(DotParser.NodeStmtContext ctx) {
            String id =  asPlainString(ctx.nodeID().getText());
            Node n = graph.getNode(id, true);

            contexts.put(ctx.attrList().aList(), n);
        }

        @Override
        public void enterEdgeStmt(DotParser.EdgeStmtContext ctx) {
            String lhsId = asPlainString(ctx.nodeID().getText());
            String op = ctx.edgeRHS().edgeOp().getText();
            String rhsId = asPlainString(ctx.edgeRHS().nodeID().getText());

            Node lhs = graph.getNode(lhsId, true);
            Node rhs = graph.getNode(rhsId, true);
            Edge e = new Edge(lhs, asOpType(op), rhs);

            contexts.put(ctx.attrList().aList(), e);

            graph.edges.add(e);
        }

        @Override
        public void enterAList(DotParser.AListContext ctx) {
            String name = ctx.ID(0).getText();
            String value = ctx.ID(1).getText();

            AttributedEntity entity = contexts.get(ctx);
            if (entity != null) entity.setAttribute(asPlainString(name), asPlainString(value));
            else System.out.format("Ignoring attribute %s=%s\n", name, value);

            contexts.put(ctx.aList(), entity);
        }

        public Graph getGraph() {
            return graph;
        }

        private String asPlainString(String token) {
            if (token.startsWith("\"")) return token.substring(1, token.length() - 1);
            else return token;
        }

        private Edge.OpType asOpType(String token) {
            for (Edge.OpType op : Edge.OpType.values()) {
                if (token.equals(op.label)) return op;
            }

            return null;
        }

    }

    protected final Boolean isDigraph;

    protected final Set<Node> nodes = new HashSet<>();

    protected final Set<Edge> edges = new HashSet<>();

    public Graph() {
        this(false);
    }

    public Graph(Boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Node getNode(String id, Boolean addIfAbsent) {
        for (Node n : nodes) {
            if (n.getId().equals(id)) return n;
        }

        if (!addIfAbsent) return null;

        Node n = new Node(id);
        nodes.add(n);
        return n;
    }

    public Node getNode(String id) {
        return getNode(id, false);
    }

    public void addNode(Node n) {
        // TODO merge if node already exists (but with different attributes)
        nodes.add(n);
    }

    public void addEdge(Edge e) {
        // TODO merge if edge already exists (but with different attributes)
        edges.add(e);
    }

    public void removeNode(Node n) {
        Set<Edge> toRemove = new HashSet<>();

        for (Edge e : edges) {
            if (e.getLHS().equals(n)) toRemove.add(e);
            if (e.getRHS().equals(n)) toRemove.add(e);
        }

        nodes.remove(n);
        edges.removeAll(toRemove);
    }

    @Override
    public String toString() {
        String type = isDigraph ? "digraph" : "graph";

        StringBuilder nb = new StringBuilder();
        nodes.forEach(n -> nb.append(n.toString() + "\n"));

        StringBuilder eb = new StringBuilder();
        edges.forEach(e -> eb.append(e.toString() + "\n"));

        return String.format("%s {\ngraph %s;\n%s\n%s}", type, listAttributes(), nb, eb);
    }

    public static Graph build(Model g) {
        Graph dot = new Graph(true);

        for (Statement t : g) {
            if (!EG.isEGTriple(t)) {
                String s = t.getSubject().stringValue();
                String p = t.getPredicate().stringValue();
                String o = t.getObject().stringValue();

                Node lhs = dot.getNode(s, true);
                Node rhs = dot.getNode(o, true);

                if (t.getPredicate().equals(RDF.TYPE)) p = "a";

                Edge e = new Edge(lhs, Edge.OpType.DirectedOp, rhs);
                e.setAttribute("label", p);
                dot.edges.add(e);
            }
        }

        return dot;
    }

    public static Graph build(InputStream input) throws IOException {
        CharStream in = CharStreams.fromStream(input, Charset.defaultCharset());
        DotLexer lexer = new DotLexer(in);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DotParser parser = new DotParser(tokens);

        ParseTree ast = parser.graph();
        GraphBuilder builder = new GraphBuilder();
        ParseTreeWalker.DEFAULT.walk(builder, ast);

        return builder.getGraph();
    }

}
