package fr.emse.gv;

import fr.emse.dot.Graph;

import java.io.File;
import java.io.PrintWriter;

public class GraphvizProcess {

    public void run(Graph g) throws Exception {
        ProcessBuilder psb = new ProcessBuilder("dot", "-Tpng", "-otest.png");
        psb.redirectError(new File("error.log"));

        Process ps = psb.start();

        PrintWriter w = new PrintWriter(ps.getOutputStream());
        w.write(g.toString());
        w.close();

        ps.waitFor();
    }

}
