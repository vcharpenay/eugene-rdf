package fr.emse.gv;

import fr.emse.dot.Graph;
import fr.emse.dot.GraphTest;
import fr.emse.gv.GraphvizProcess;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class GraphvizProcessTest {

    @Test
    public void testLayOut() throws Exception {
        InputStream i = open("test.dot");

        Graph g = Graph.build(i);
        g = GraphvizProcess.layOut(g);

        assert g.getAttribute("bb") != null;
    }

    public InputStream open(String resourceName) {
        return GraphvizProcessTest.class.getClassLoader().getResourceAsStream(resourceName);
    }

}
