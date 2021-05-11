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

    protected final String lhs;

    protected final String rhs;

    protected final OpType op;

    public Edge(String lhs, OpType op, String rhs) {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" %s \"%s\" %s;", lhs, op.label, rhs, listAttributes());
    }

}
