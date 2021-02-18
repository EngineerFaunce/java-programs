import java.util.ArrayList;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public Graph() {
        vertices = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param v Vertex to be added
     */
    public void addVertex(Vertex v) {
        this.vertices.add(v);
    }

    /**
     * Checks a graph's ArrayList of type Vertex to check if it contains the given element.
     *
     * @param element the element we want to search the graph for
     * @return boolean indicating if the graph contains the given element
     */
    public boolean containsVertex(char element) {
        for (Vertex vertex : this.vertices) {
            if (vertex.getNode() == element) {
                return true;
            }
        }
        return false;
    }
}


