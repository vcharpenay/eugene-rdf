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
            String id =  ctx.nodeID().getText();
            Node n = new Node(asPlainString(id));

            contexts.put(ctx.attrList().aList(), n);

            graph.nodes.add(n);
        }

        @Override
        public void enterEdgeStmt(DotParser.EdgeStmtContext ctx) {
            String lhs = ctx.nodeID().getText();
            String op = ctx.edgeRHS().edgeOp().getText();
            String rhs = ctx.edgeRHS().nodeID().getText();
            Edge e = new Edge(asPlainString(lhs), asOpType(op), asPlainString(rhs));

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

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addEdge(Edge e) {
        edges.add(e);
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

                dot.nodes.add(new Node(s));
                dot.nodes.add(new Node(o));

                Edge e = new Edge(s, Edge.OpType.DirectedOp, o);
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
