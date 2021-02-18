public class Edge {
    private char node1;
    private char node2;

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
}
