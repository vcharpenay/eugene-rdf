package fr.emse.eg;

import fr.emse.dot.AttributedEntity;
import fr.emse.dot.Edge;
import fr.emse.dot.Graph;
import fr.emse.dot.Node;
import fr.emse.gv.GraphvizProcess;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;

import java.util.*;

public class Surface {

    /**
     * padding within surfaces, in points (pt)
     */
    public static final Double SURFACE_PADDING = 10d;

    public enum SurfaceType {
        POSITIVE("LimeGreen"),
        NEGATIVE("Firebrick"),
        NEUTRAL("LightSlateGray"),
        MODAL("SlateBlue");

        public final String color;

        SurfaceType(String color) {
            this.color = color;
        }

        public static SurfaceType forClassName(IRI className) {
            if (className.equals(EG.POSITIVE_SURFACE)) return POSITIVE;
            else if (className.equals(EG.NEGATIVE_SURFACE)) return NEGATIVE;
            else if (className.equals(EG.NEUTRAL_SURFACE)) return NEUTRAL;
            else if (className.equals(EG.MODAL_SURFACE)) return MODAL;
            else return null;
        }
    }

    private final Model graph = new LinkedHashModel();

    private final SurfaceType type;

    private final Set<Surface> containedSurfaces = new HashSet<>();

    public Surface(Model dataset) {
        this(dataset, null, SurfaceType.POSITIVE);
    }

    Surface(Model dataset, IRI graphName, SurfaceType type) {
        Model namedGraph = dataset.filter(null, null, null, graphName);

        for (Statement t : namedGraph) {
            if (EG.isEGTriple(t)) {
                IRI subGraphName = (IRI) t.getSubject();
                IRI subtype = (IRI) t.getObject();
                Surface s = new Surface(dataset, subGraphName, SurfaceType.forClassName(subtype));
                containedSurfaces.add(s);
            } else {
                graph.add(t);
            }
        }

        this.type = type;
    }

    public Model getGraph() {
        return graph;
    }

    public SurfaceType getType() {
        return type;
    }

    /**
     * Produces a DOT graph by recursively laying out surfaces contained in the current surface.
     *
     * @return an abstract syntax tree of a DOT graph, recursively laid out
     * @throws Exception TODO handle exceptions
     */
    public Graph toDOT() throws Exception {
        Graph g = Graph.build(graph);

        Map<Graph, String> surfaceNodes = new HashMap<>();

        Set<Edge> overlapEdges = new HashSet<>();
        Set<Edge> substituteEdges = new HashSet<>();

        for (Surface s : containedSurfaces) {
            Graph sg = s.toDOT();

            for (Node n : g.getNodes()) {
                for (Node sn : sg.getNodes()) {
                    if (getLocalId(n).equals(getLocalId(sn))) {
                        Edge e = new Edge(n, Edge.OpType.DirectedOp, sn);
                        e.setAttribute("style", "dashed");
                        e.setAttribute("arrowhead", "none");

                        overlapEdges.add(e);
                    }
                }
            }

            List<Double> boundingBox = sg.getNumbersAttribute("bb");
            Double width = AttributedEntity.pt2in(boundingBox.get(2) + 2 * SURFACE_PADDING);
            Double height = AttributedEntity.pt2in(boundingBox.get(3) + 2 * SURFACE_PADDING);

            Node n = new Node(Integer.toHexString(sg.hashCode()));
            n.setAttribute("width", width.toString());
            n.setAttribute("height", height.toString());
            n.setAttribute("shape", "rect");
            n.setAttribute("fixedsize", "true");
            n.setAttribute("label", "");
            n.setAttribute("penwidth", "2");
            n.setAttribute("color", s.getType().color);

            g.addNode(n);
            surfaceNodes.put(sg, n.getId());

            for (Edge e : overlapEdges) {
                Edge substitute = new Edge(e.getLHS(), e.getOp(), n);

                g.addEdge(substitute);
                substituteEdges.add(substitute);
            }
        }

        Graph merged = GraphvizProcess.layOut(g);

        for (Graph sg : surfaceNodes.keySet()) {
            Node surface = merged.getNode(surfaceNodes.get(sg));
            List<Double> center = surface.getNumbersAttribute("pos");
            Double width = surface.getNumberAttribute("width");
            Double height = surface.getNumberAttribute("height");
            Double x0 = center.get(0) - AttributedEntity.in2pt(width / 2) + SURFACE_PADDING;
            Double y0 = center.get(1) - AttributedEntity.in2pt(height / 2) + SURFACE_PADDING;

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

        merged.getEdges().addAll(overlapEdges);
        merged.getEdges().removeAll(substituteEdges);

        return merged;
    }

    private String getLocalId(Node n) {
        // TODO use inheritance for cleaner comparison?
        String[] id = n.getId().split(Graph.CONTEXT_SEPARATOR);

        if (id.length == 1) return id[0];
        else return id[1];
    }

}
