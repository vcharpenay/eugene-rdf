package fr.emse.dot;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

public class GraphTest {

    private static final IRI G2_IRI = SimpleValueFactory.getInstance().createIRI("file:///g2");

    @Test
    public void testBuildModel() throws IOException {
        InputStream i = open("test.trig");

        Model ds = Rio.parse(i, "file:///", RDFFormat.TRIG);
        Model g2 = ds.filter(null, null, null, G2_IRI);

        Graph built = Graph.build(g2);

        assert built.getNodes().size() == 2;
        assert built.getEdges().size() == 1;
    }

    @Test
    public void testBuildStream() throws IOException {
        InputStream i = open("test.dot");

        Graph built = Graph.build(i);

        assert built.getNodes().size() == 0; // FIXME an edge should contain refs to nodes
        assert built.getEdges().size() == 1;
    }

    @Test
    public void testRoundTrip() throws IOException {
        InputStream i = open("test.dot");

        Graph built = Graph.build(i);

        byte[] buf = built.toString().getBytes();
        i = new ByteArrayInputStream(buf);

        built = Graph.build(i);

        assert built.getNodes().size() == 0; // FIXME see above
        assert built.getEdges().size() == 1;
    }

    private InputStream open(String resourceName) {
        return GraphTest.class.getClassLoader().getResourceAsStream(resourceName);
    }

}
