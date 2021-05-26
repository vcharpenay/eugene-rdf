package fr.emse.dot;

import org.eclipse.rdf4j.model.IRI;

public class Node extends AttributedEntity {

    protected final String id;

    public Node(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return id.equals(((Node) o).getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("\"%s\" %s;", id, listAttributes());
    }

    public static Node build(IRI id) {
        return new Node(id.stringValue());
    }

}
