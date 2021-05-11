package fr.emse.dot;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;

import java.util.HashSet;
import java.util.Set;

/**
 * Data structure holding the abstract syntax tree of a DOT file
 */
public class Graph extends AttributedEntity {

    protected final Boolean isDigraph;

    protected final Set<Node> nodes = new HashSet<>();

    protected final Set<Edge> edges = new HashSet<>();

    public Graph() {
        this(false);
    }

    public Graph(Boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    @Override
    public String toString() {
        String type = isDigraph ? "digraph" : "graph";

        StringBuilder nb = new StringBuilder();
        nodes.forEach(n -> nb.append(n.toString() + " "));

        StringBuilder eb = new StringBuilder();
        edges.forEach(e -> eb.append(e.toString() + " "));

        return String.format("%s { %s%s }", type, nb, eb);
    }

    public static Graph build(Model ds, IRI graphName) {
        Graph dot = new Graph(true);

        Model g = ds.filter(null, null, null, graphName);

        for (Statement t : g) {
            String s = t.getSubject().stringValue();
            String p = t.getPredicate().stringValue();
            String o = t.getObject().stringValue();

            dot.nodes.add(new Node(s));
            dot.nodes.add(new Node(o));

            Edge e = new Edge(s, Edge.OpType.DirectedOp, o);
            e.setAttribute("label", p);
            dot.edges.add(e);
        }

        return dot;
    }

}
