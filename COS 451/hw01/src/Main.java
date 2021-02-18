import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawInput;

        System.out.print("Program by William Faunce\n");
        System.out.print("Enter a parenthesized list of elements: ");
        rawInput = scan.nextLine();

        System.out.printf("Raw input: %s\n", rawInput);
        Graph graph = processInput(rawInput);

        System.out.println("Graph vertices: " + graph.getVertices().toString());
        System.out.println("Graph edges: " + graph.getEdges().toString());
    }

    /**
     * Processes a user's input and creates a graph containing a
     * list of vertices and edges.
     *
     * @param input raw user input
     * @return returns a Graph containing the vertices and edges of the given input
     */
    public static Graph processInput(String input) {
        Graph graph = new Graph();
        // remove all whitespace from user's input
        String output = input.replaceAll("\\s+","");

        // regex pattern for matching the 'words' of the input
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(output);

        // main loop where we parse the user's input
        while (matcher.find()) {
            String temp = matcher.group();  // assigns match to temporary string

            // check if graph contains vertex.
            // If it does not, initialize one and add it to the graph.
            char element1 = temp.charAt(0);
            if (!graph.containsVertex(element1)) {
                Vertex v = new Vertex(element1);
                graph.addVertex(v);
            }

            // case: node pair (e.g. (a b))
            if (temp.length() > 1) {
                char element2 = temp.charAt(1);
                if (!graph.containsVertex(element2)) {
                    Vertex v = new Vertex(element2);
                    graph.addVertex(v);
                }

                // check if graph contains an edge with these two elements.
                // If it does not, initialize one and add it to the graph.
                if (!graph.containsEdge(element1, element2)) {
                    Edge edge = new Edge(element1, element2);

                    // lexicographically sorts the two vertices of the edge before adding it to the graph
                    edge.sortVertices();
                    graph.addEdge(edge);
                }
            }
        }

        // sorts the graph's list of edges in lexicographic order
        graph.sortEdges();

        return graph;
    }
}
