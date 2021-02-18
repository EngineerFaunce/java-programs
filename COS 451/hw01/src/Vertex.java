public class Vertex {
    private char node;

    // initializes a vertex
    public Vertex(char n) {
        node = n;
    }

    public char getNode() {
        return node;
    }

    public void setNode(char node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "" + this.node;
    }
}
