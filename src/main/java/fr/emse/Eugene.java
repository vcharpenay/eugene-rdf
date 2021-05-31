package fr.emse;

import fr.emse.dot.Graph;
import fr.emse.eg.Surface;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Locale;

/**
 * Entry point of the Eugene utility to generate existential graphs from RDF datasets using the eg: vocabulary.
 */
public class Eugene {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: eugene-rdf <input_file.trig> <output_file.dot>");
            return;
        }

        String in = args[0];
        String out = args[1];

        // the DOT language uses US standards; change locale for default serializations
        Locale.setDefault(Locale.forLanguageTag("en-US"));

        File f = new File(in);

        Model ds = Rio.parse(new FileInputStream(f), String.format("file://%s", f.getAbsolutePath()), RDFFormat.TRIG);

        Surface s = new Surface(ds);

        // TODO check no cycle exists in surface hierarchy

        Graph eg = s.toDOT();

        FileWriter writer = new FileWriter(out);
        writer.append(eg.toString());
        writer.close();
    }

}
