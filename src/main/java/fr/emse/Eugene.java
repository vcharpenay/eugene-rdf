package fr.emse;

import fr.emse.dot.Graph;
import fr.emse.eg.Surface;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Locale;

/**
 * Entry point of the Eugene utility to generate existential graphs from RDF datasets using the eg: vocabulary.
 */
public class Eugene {

    public static void main(String[] args) throws Exception {
        // the DOT uses en-US standards; change locale for default serializations
        Locale.setDefault(Locale.forLanguageTag("en-US"));

        String f = "test.trig";

        Model ds = Rio.parse(new FileInputStream(f), "file:///", RDFFormat.TRIG);

        Surface s = new Surface(ds);

        // TODO check no cycle exists in surface hierarchy

        Graph eg = s.toDOT();

        FileWriter writer = new FileWriter("test-eg.dot");
        writer.append(eg.toString());
        writer.close();
    }

}
