package fr.emse.dot;

import java.util.Objects;

public class Edge extends AttributedEntity {

    public enum OpType {
        DirectedOp("->"),
        UndirectedOp("--");

        public final String label;

        OpType(String label) {
            this.label = label;
        }
    }

    protected final Node lhs;

    protected final Node rhs;

    protected final OpType op;

    public Edge(Node lhs, OpType op, Node rhs) {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
    }

    public Node getLHS() {
        return lhs;
    }

    public Node getRHS() {
        return rhs;
    }

    public OpType getOp() {
        return op;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(lhs, edge.lhs) && Objects.equals(rhs, edge.rhs) && op == edge.op;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lhs, rhs, op);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" %s \"%s\" %s;", lhs.getId(), op.label, rhs.getId(), listAttributes());
    }

}
