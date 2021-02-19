public class Edge implements Comparable<Edge> {
    private char node1;     // first node
    private char node2;     // second node

    /**
     * Constructs an Edge instance.
     *
     * @param n1 first vertex
     * @param n2 second vertex
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
     * Checks if an Edge contains a certain node.
     *
     * @param n Node to search for
     * @return boolean indicating whether the Edge contains a given node
     */
    public boolean containsNode(char n) {
        return (this.node1 == n) || (this.node2 == n);
    }

    /**
     * Sorts the two nodes in lexicographic order.
     */
    public void sortNodes() {
        // lexicographically sorts the two elements
        if (this.node1 > this.node2) {
            char tempNode = this.node1;
            this.node1 = this.node2;
            this.node2 = tempNode;
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
