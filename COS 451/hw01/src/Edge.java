public class Edge implements Comparable<Edge> {
    private char node1;     // first vertex
    private char node2;     // second vertex
    private int value;     // combined char value of the two vertices

    /**
     * Constructs an Edge instance.
     * Note: assumes that the two vertices are sorted lexicographically
     * at the time of creation.
     *
     * @param n1 char representation of first vertex
     * @param n2 char representation of second vertex
     */
    public Edge(char n1, char n2) {
        node1 = n1;
        node2 = n2;
        value = node1 + node2;
    }

    public char getNode1() {
        return node1;
    }

    public char getNode2() {
        return node2;
    }

    public void setNode1(char node1) {
        this.node1 = node1;
    }

    public void setNode2(char node2) {
        this.node2 = node2;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Sorts the two vertices in lexicographic order.
     */
    public void sortVertices() {
        // lexicographically sorts the two elements
        if (this.node1 > this.node2) {
            char tempElement = this.node1;
            this.node1 = this.node2;
            this.node2 = tempElement;
        }
    }

    @Override
    public String toString() {
        return "(" + this.node1 + " " + this.node2 + ")";
    }

    @Override
    public int compareTo(Edge edge) {
        int compareValue = ((Edge) edge).getValue();

        return this.value - compareValue;
    }
}
