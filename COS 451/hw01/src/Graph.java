import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class Graph {
    private ArrayList<Character> nodes;
    private ArrayList<Edge> edges;

    public Graph() {
        nodes = new ArrayList<Character>();
        edges = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Character> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Character> nodes) {
        this.nodes = nodes;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Adds a node to the graph.
     *
     * @param n Node to be added
     */
    public void addNode(char n) {
        this.nodes.add(n);
    }

    /**
     * Removes a vertex from the graph.
     *
     * @param v Vertex to be removed
     */
    public void removeNode(char v) {
        this.nodes.remove(v);
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
     * Removes an edge from the graph.
     *
     * @param e Edge to be removed.
     */
    public void removeEdge(Edge e) {
        this.edges.remove(e);
    }

    /**
     * Checks if a graph contains an Edge.
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
     * Checks if a graph contains an Edge.
     *
     * @param e Edge to search for
     * @return boolean indicating if the graph contains the Edge
     */
    public boolean containsEdge(Edge e) {
        for (Edge edge : this.edges) {
            if ((edge.getNode1() == e.getNode1()) && (edge.getNode2() == e.getNode2())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts a graph's nodes in lexicographic order
     */
    public void sortNodes() {
        Collections.sort(this.nodes);
    }

    /**
     * Sorts a graph's edges in lexicographic order by comparing
     * the Edge's character values of its two nodes.
     */
    public void sortEdges() {
        Collections.sort(this.edges);
    }

    /**
     * Find all the edges containing a given Vertex.
     *
     * @param v Vertex to search edge pairs for
     * @return ArrayList<Edge> containing each Edge containing the given Vertex
     */
    public ArrayList<Edge> findEdges(char v) {
        ArrayList<Edge> result = new ArrayList<Edge>();
        for (Edge edge : this.edges) {
            if (edge.containsNode(v)) {
                result.add(edge);
            }
        }
        return result;
    }

    /**
     * Returns the degree of a node in a graph.
     *
     * @param n Node to find the degree of
     * @return an integer representing a node's degree, or -1 if the graph does not contain the given node
     */
    public int getDegree(char n) {
        int count = 0;

        // ensure graph contains this vertex
        if (this.nodes.contains(n)) {
            if (!this.findEdges(n).isEmpty()) {
                for (Edge edge : this.findEdges(n)) {
                    count += 1;
                }
            }
            return count;
        }
        return -1;
    }

//    @Override
//    public String toString() {
//        // TODO (optional): change how the graph outputs its nodes and edges in the console
//    }
}


