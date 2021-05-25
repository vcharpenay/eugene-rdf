package fr.emse.dot;

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

    @Override
    public String toString() {
        return String.format("\"%s\" %s \"%s\" %s;", lhs.getId(), op.label, rhs.getId(), listAttributes());
    }

}
