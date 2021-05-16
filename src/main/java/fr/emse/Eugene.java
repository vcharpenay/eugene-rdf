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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Entry point of the Eugene utility to generate existential graphs from RDF datasets using the eg: vocabulary.
 */
public class Eugene {

    public static void main(String[] args) throws Exception {
        String f = "test.trig";

        Model ds = Rio.parse(new FileInputStream(f), "file:///", RDFFormat.TRIG);

        Graph eg = merge(ds, null);

        FileWriter writer = new FileWriter("test-eg.dot");
        writer.append(eg.toString());
        writer.close();
    }

    public static Graph merge(Model dataset, IRI graphName) throws Exception {
        Model namedGraph = dataset.filter(null, null, null, graphName);

        Set<Graph> subGraphs = new HashSet<>();

        for (Statement t : namedGraph) {
            if (EG.isEGTriple(t)) {
                IRI subGraphName = (IRI) t.getSubject();
                subGraphs.add(merge(dataset, subGraphName));
            }
        }

        Graph g = Graph.build(namedGraph);

        for (Graph sg : subGraphs) {
            List<Double> boundingBox = sg.getNumbersAttribute("bb");
            Double width = boundingBox.get(2);
            Double height = boundingBox.get(3);

            Node n = new Node(Integer.toHexString(sg.hashCode()));
//            n.setAttribute("width", width.toString());
//            n.setAttribute("height", height.toString());

            g.addNode(n);

            // TODO edges from any node in g to nodes in sg
        }

        Graph merged = GraphvizProcess.layOut(g);

        // TODO merge all

        for (Graph sg : subGraphs) {
            for (Node n : sg.getNodes()) merged.addNode(n);
            for (Edge e : sg.getEdges()) merged.addEdge(e);
        }

        return merged;
    }

}
