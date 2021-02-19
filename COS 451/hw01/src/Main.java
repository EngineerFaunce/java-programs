import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawInput;

        System.out.print("Program by William Faunce\n\n");
        System.out.print("Enter a parenthesized list of elements: ");
        rawInput = scan.nextLine();

        Graph graph = processInput(rawInput);
        processGraph(graph);
    }

    /**
     * Processes a user's input and creates a graph containing a
     * list of nodes and edges.
     *
     * @param input raw user input
     * @return returns a Graph containing the nodes and edges of the given input
     */
    public static Graph processInput(String input) {
        System.out.printf("Raw user input: %s\n", input);
        Graph graph = new Graph();

        // remove all whitespace from user's input
        String output = input.replaceAll("\\s+","");

        // regex pattern for matching the 'words' of the input
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(output);

        // main loop where we parse the user's input
        while (matcher.find()) {
            String temp = matcher.group();  // assigns match to temporary string
            if (temp.length() > 2) {
                System.out.println("Expected a match of length 1 or length 2. Got: " + temp.length());
                System.exit(1);
            }

            char n1;
            char n2;

            // check if graph contains node with the first value.
            // If it does not, initialize one and add it to the graph.
            n1 = temp.charAt(0);
            if (!graph.getNodes().contains(n1)) {
                graph.addNode(n1);
            }

            // case: node pair (e.g. (a b))
            if (temp.length() == 2) {
                n2 = temp.charAt(1);
                if (!graph.getNodes().contains(n2)) {
                    graph.addNode(n2);
                }

                // check if graph contains an edge with these two elements.
                // If it does not, initialize one and add it to the graph.
                if ((!graph.containsEdge(n1, n2)) && (!graph.containsEdge(n2, n1))) {
                    Edge edge = new Edge(n1, n2);

                    // lexicographically sorts the two nodes of the edge before adding it to the graph
                    edge.sortNodes();
                    graph.addEdge(edge);
                }
            }
        }
        // sorts the graph's nodes and edges in lexicographic order
        graph.sortNodes();
        graph.sortEdges();

        System.out.println("Graph vertices: " + graph.getNodes().toString());
        System.out.println("Graph edges: " + graph.getEdges().toString() + "\n");

        return graph;
    }

    /**
     * Processes a Graph and adds nodes to a list representing the clique of the graph OR
     * to a list representing the independent set.
     *
     * @param graph Graph that contains a list of nodes and edges
     */
    public static void processGraph(Graph graph) {
        ArrayList<Character> pileA = new ArrayList<>();
        ArrayList<Character> pileB = new ArrayList<>();
        double nodeRemaining = graph.getNodes().size();

        ArrayList<Edge> edgeCopy = new ArrayList<Edge>(graph.getEdges());

        while (graph.getNodes().size() > 0) {
            char node = graph.getNodes().get(0);
            int nodeDegree = graph.getDegree(node);

            // edges containing the currently processed node.
            ArrayList<Edge> nodeEdges = graph.findEdges(node);

            nodeRemaining = (double) graph.getNodes().size() - 1;
            if (nodeDegree > (nodeRemaining / 2)) {
                pileA.add(node);

                /* case pileA: Remove nodes that the processed node is not connected to */

                // mark nodes nodes connected to current node as safe
                ArrayList<Character> safeNodes = new ArrayList<Character>();
                for (Edge edge : nodeEdges) {
                    if (!safeNodes.contains(edge.getNode2())) {
                        safeNodes.add(edge.getNode2());
                    }
                }

                ArrayList<Character> unsafeNodes = new ArrayList<Character>();
                for (char n : graph.getNodes()) {
                    if(!safeNodes.contains(n)) {
                        unsafeNodes.add(n);
                    }
                }

                // removes nodes not a part of the safeNodes list as well as processed node
                ArrayList<Character> tempVertices = graph.getNodes();
                tempVertices.removeAll(unsafeNodes);
                graph.setNodes(tempVertices);
            }
            else {
                pileB.add(node);

                /* case pileB: Remove nodes that the current node is connected to */

                // mark nodes connected to current node for removal
                ArrayList<Character> unsafeNodes = new ArrayList<Character>();
                for (Edge edge : nodeEdges) {
                    unsafeNodes.add(edge.getNode2());
                }
                unsafeNodes.add(node);

                // removes nodes from graph that were marked for removal
                ArrayList<Character> tempVertices = graph.getNodes();
                tempVertices.removeAll(unsafeNodes);
                graph.setNodes(tempVertices);
            }

            // remove edges where the processed node was a part of it
            ArrayList<Edge> tempEdges = graph.getEdges();
            tempEdges.removeAll(nodeEdges);
            graph.setEdges(tempEdges);
        }

        // process pileA for correct formatting
        ArrayList<Edge> cliqueEdges = new ArrayList<Edge>();
        if (!pileA.isEmpty()) {
            for (Edge edge : edgeCopy) {
                if (pileA.contains(edge.getNode1()) &&  pileA.contains(edge.getNode2())) {
                    cliqueEdges.add(edge);
                }
            }
        }

        // Output
        System.out.print("Cliques of graph: (");
        for (Edge edge : cliqueEdges) {
            System.out.printf("(%s %s)", edge.getNode1(), edge.getNode2());
        }

        System.out.print(")\nIndependent set of graph: (");
        for (char node : pileB) {
            System.out.printf("(%s)", node);
        }
        System.out.print(")");
    }
}
