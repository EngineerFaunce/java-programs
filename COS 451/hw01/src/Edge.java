public class Edge implements Comparable<Edge> {
    private char node1;     // first vertex
    private char node2;     // second vertex

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
        int result = Character.compare(this.getNode1(), edge.getNode1());

        // case: the first vertex of each edge is the same
        if (result == 0) {
            result = Character.compare(this.getNode2(), edge.getNode2());
        }
        return result;
    }
}
