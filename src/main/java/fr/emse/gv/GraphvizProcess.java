package fr.emse.gv;

import fr.emse.dot.Graph;

import java.io.File;
import java.io.PrintWriter;

public class GraphvizProcess {

    public static Graph layOut(Graph g) throws Exception {
        ProcessBuilder psb = new ProcessBuilder("dot", "-Tdot");
        psb.redirectError(new File("error.log"));

        Process ps = psb.start();

        PrintWriter w = new PrintWriter(ps.getOutputStream());
        w.write(g.toString());
        w.close();

        ps.waitFor();

        return Graph.build(ps.getInputStream());
    }

}
