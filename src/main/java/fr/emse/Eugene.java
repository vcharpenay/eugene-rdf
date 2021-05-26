package fr.emse;

import fr.emse.dot.Edge;
import fr.emse.dot.Graph;
import fr.emse.dot.Node;
import fr.emse.eg.EG;
import fr.emse.gv.GraphvizProcess;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

/**
 * Entry point of the Eugene utility to generate existential graphs from RDF datasets using the eg: vocabulary.
 */
public class Eugene {

    /**
     * padding within surfaces, in points (pt)
     */
    public static final Double SURFACE_PADDING = 10d;

    public static void main(String[] args) throws Exception {
        // the DOT uses en-US standards; change locale for default serializations
        Locale.setDefault(Locale.forLanguageTag("en-US"));

        String f = "test.trig";

        Model ds = Rio.parse(new FileInputStream(f), "file:///", RDFFormat.TRIG);

        Graph eg = merge(ds, null);

        FileWriter writer = new FileWriter("test-eg.dot");
        writer.append(eg.toString());
        writer.close();
    }

    public static Graph merge(Model dataset, IRI graphName) throws Exception {
        Model namedGraph = dataset.filter(null, null, null, graphName);

        Graph g = Graph.build(namedGraph);

        Map<Graph, String> subGraphs = new HashMap<>();

        Set<Edge> substitutes = new HashSet<>();

        for (Statement t : namedGraph) {
            if (EG.isEGTriple(t)) {
                IRI subGraphName = (IRI) t.getSubject();
                IRI surface = (IRI) t.getObject();
                Graph sg = merge(dataset, subGraphName); // TODO remove nodes in g before calling merge

                List<Double> boundingBox = sg.getNumbersAttribute("bb");
                Double width = pt2in(boundingBox.get(2) + 2 * SURFACE_PADDING);
                Double height = pt2in(boundingBox.get(3) + 2 * SURFACE_PADDING);

                Node n = new Node(Integer.toHexString(sg.hashCode()));
                n.setAttribute("width", width.toString());
                n.setAttribute("height", height.toString());
                n.setAttribute("shape", "rect");
                n.setAttribute("fixedsize", "true");
                n.setAttribute("label", "");
                n.setAttribute("penwidth", "2");
                n.setAttribute("color", EG.getSurfaceColor(surface));

                g.addNode(n);
                subGraphs.put(sg, n.getId());

                for (Edge e : sg.getEdges()) {
                    Node lhs = e.getLHS();
                    if (g.getNode(lhs.getId()) != null) {
                        Edge sub = new Edge(lhs, e.getOp(), n);
                        substitutes.add(sub);
                        g.addEdge(sub);
                    }

                    Node rhs = e.getRHS();
                    if (g.getNode(rhs.getId()) != null) {
                        Edge sub = new Edge(n, e.getOp(), rhs);
                        substitutes.add(sub);
                        g.addEdge(sub);
                    }
                }

                // TODO if both edge sides are in g?
            }
        }

        Graph merged = GraphvizProcess.layOut(g);

        for (Graph sg : subGraphs.keySet()) {
            Node surface = merged.getNode(subGraphs.get(sg));
            List<Double> center = surface.getNumbersAttribute("pos");
            Double width = surface.getNumberAttribute("width");
            Double height = surface.getNumberAttribute("height");
            Double x0 = center.get(0) - in2pt(width / 2) + SURFACE_PADDING;
            Double y0 = center.get(1) - in2pt(height / 2) + SURFACE_PADDING;

            // translate all nodes along vector (x0, y0)
            for (Node n : sg.getNodes()) {
                List<Double> pos = n.getNumbersAttribute("pos");
                Double x = x0 + pos.get(0);
                Double y = y0 + pos.get(1);

                n.setAttribute("pos", String.format("%f,%f", x, y));

                merged.addNode(n);
            }

            for (Edge e : sg.getEdges()) {
                e.setAttribute("pos", ""); // TODO remove attribute instead
                merged.addEdge(e);
            }
        }

        merged.getEdges().removeAll(substitutes);

        return merged;
    }

    /**
     * Conversion from inches (default measurement unit in Graphviz) to points (used by neato for positioning).
     *
     * @param in value in inches (in)
     * @return converted value in points (pt)
     */
    private static Double in2pt(Double in) {
        return in * 72;
    }

    /**
     * Inverse conversion w.r.t. {@code in2pt}.
     *
     * @param pt value in points (pt)
     * @return converted value in inches (in)
     */
    private static Double pt2in(Double pt) {
        return pt / 72;
    }

}
