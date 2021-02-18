import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rawInput;
        Graph graph = new Graph();

        System.out.print("Program by William Faunce\n");
        System.out.print("Enter a parenthesized list of elements: ");
        rawInput = scan.nextLine();

        System.out.printf("Raw input: %s\n", rawInput);
        //processInput(rawInput);


    }

    /**
     * Processes a user's input and creates a graph containing a
     * list of vertices and edges.
     *
     * @param input raw user input
     * @param graph graph containing an ArrayList for both vertices and edges
     */
    public static void processInput(String input, Graph graph) {
        // remove all whitespace from user's input
        String output = input.replaceAll("\\s+","");

        // regex pattern for matching the 'words' of the input
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(output);


        while (matcher.find()) {
            String temp = matcher.group();  // assigns match to temporary string

            // check if graph contains vertex. If it does not, initialize one and add it to graph
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

                // TODO: check if the graph contains an edge betweeen element 1 and element 2
            }
        }
    }
}
