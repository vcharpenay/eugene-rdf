package fr.emse;

import fr.emse.dot.Graph;
import fr.emse.gv.GraphvizProcess;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.FileInputStream;

/**
 * Entry point of the Eugene utility to generate existential graphs from RDF datasets using the eg: vocabulary.
 */
public class Eugene {

    public static void main(String[] args) throws Exception {
        String f = "test.trig";

        Model ds = Rio.parse(new FileInputStream(f), "file:///", RDFFormat.TRIG);

        ValueFactory vf = SimpleValueFactory.getInstance();

        Graph g = Graph.build(ds, vf.createIRI("file:///g1"));

        new GraphvizProcess().run(g);
    }

}
