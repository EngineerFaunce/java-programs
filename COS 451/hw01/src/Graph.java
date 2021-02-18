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
     * Adds an edge to the graph.
     *
     * @param e Edge to be added.
     */
    public void addEdge(Edge e) {
        this.edges.add(e);
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

    /**
     * Checks if a graph contains an Edge.
     * Note: assumes that the two vertices are sorted lexicographically
     * before performing the search.
     *
     * @param element1 char representation of a Vertex
     * @param element2 char representation of a Vertex
     * @return boolean indicating if the graph contains the Edge
     */
    public boolean containsEdge(char element1, char element2) {
        for (Edge edge : this.edges) {
            if ((edge.getNode1() == element1 && edge.getNode2() == element2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts a graph's edges in lexicographic order by comparing
     * the Edge's character values of its two vertices.
     */
    public void sortEdges() {
        for (int i=0; i < edges.size()-1; i++) {
            Edge temp, e1, e2;
            temp = e1 = this.edges.get(i);
            e2 = this.edges.get(i+1);

            // compares the combined character values of each "vertex" in an edge pair
            // and then swaps them so the lesser
            if ((e1.getNode1() + e1.getNode2()) > (e2.getNode1() + e2.getNode2())) {
                e1 = e2;
                e2 = temp;
            }
        }
    }

    public int vertexDegree(Vertex v) {
        // TODO: return degree of given vertex in graph
        return 1;
    }


}


