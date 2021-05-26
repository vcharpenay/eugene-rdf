package fr.emse.eg;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;

/**
 * Class holding term definitions of the eg: vocabulary
 */
public class EG {

    public static final String NS = "http://example.org/eg/"; // TODO proper namespace

    public static final IRI POSITIVE_SURFACE = SimpleValueFactory.getInstance().createIRI(NS + "PositiveSurface");

    public static final IRI NEGATIVE_SURFACE = SimpleValueFactory.getInstance().createIRI(NS + "NegativeSurface");

    public static final IRI NEUTRAL_SURFACE = SimpleValueFactory.getInstance().createIRI(NS + "NeutralSurface");

    public static final IRI MODAL_SURFACE = SimpleValueFactory.getInstance().createIRI(NS + "ModalSurface");

    public static boolean isEGTriple(Statement t) {
        return t.getPredicate().equals(RDF.TYPE)
            && t.getObject().stringValue().startsWith(NS);
    }

    public static String getSurfaceColor(IRI classIRI) {
        if (classIRI.equals(POSITIVE_SURFACE)) return "Lime Green";
        else if (classIRI.equals(NEGATIVE_SURFACE)) return "Firebrick";
        else if (classIRI.equals(NEUTRAL_SURFACE)) return "Light Slate Gray";
        else if (classIRI.equals(MODAL_SURFACE)) return "Slate Blue";
        else return "Black";
    }

}
