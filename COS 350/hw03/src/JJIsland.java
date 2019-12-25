
import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class JJIsland {
	
	int [][] graph;							// a graph of islands in the form of adjacency matrix
	Node node;
	ArrayList<ArrayList<Integer>> paths;

	JJIsland (String input) {
		String [] tempNum = input.split(" ");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(String s: tempNum)
			nums.add(Integer.parseInt(s));
		
		int max = findMax(nums);			// will be the dimensions of the 2D array
		graph = new int [max+1][max+1];
		
		// initializes every element of 2D array to 0
		for(int i=0; i < graph.length; i++) {
			for(int j=0; j < graph[i].length; j++)
				graph[i][j] = 0;
		}
		
		buildGraph(nums);
		
		node = new Node(nums.get(0), 0);
		
		buildTree(node);
		
		System.out.print("\n\n");
		
		Stack<ArrayList<Integer>> pathStack = findPath(node);
		
		for(ArrayList<Integer> list : pathStack)
			paths.add(list);
		
		printList(longestPath());
	}

	/*
	 * method that will set node edges to have a value of 1 in 2D array,
	 * so if a user entered the pair (1,2) then graph[1][2] and graph[2][1]
	 * would both have a value of 1 to indicate they are connected by a slide
	 */
	private void buildGraph(ArrayList<Integer> list) {
		// iterate by two because the user input is in pairs
		for(int i=0; i < list.size(); i+=2) {
			graph[list.get(i)][list.get(i+1)] = 1;
			graph[list.get(i+1)][list.get(i)] = 1;
		}
		/*
		 * uncommenting this will show completed adjacency list
		 * 
		for(int i = 1; i<graph.length; i++) {
		    for(int j = 1; j<graph.length; j++)
		        System.out.print(graph[i][j]);
		    System.out.println();
		}
		*/
	}
	
	/*
	 * recursive algorithm for building a tree where every branch that starts
	 * from the root (in this case starting island) is a potential path JJ 
	 * can follow
	 */
	private void buildTree(Node n) {
		int sum = 0;
		// this will go through each row of the 2D array to see if island i
		// is connected to another island.
		for(int i: graph[n.getValue()])
			sum += i;
		
		// if the island does connect to another, then we add children to a new node
		// where the value of the node is the current island
		if(sum > 0) {
			for(int i=1; i < graph[n.getValue()].length; i++) {
				Node temp = new Node();
				
				if(graph[n.getValue()][i] == 1) {
					temp = new Node(i, n.getValue());
					
					/* this is suppose to check that before a child
					 * gets added it does not equal the parent of the
					 * current node, otherwise we would enter an infinite
					 * loop and never complete.
					 */
					if(i != n.getParent()) {
						n.addChild(temp);
						temp.display();
					}
				}
			}
			
			ArrayList<Node> children = n.getChildren();
			
			for(Node i: children) {
				if(i.getValue() != n.getValue())
					buildTree(i);
			}
		}
		
	}
	
	// method that will take each branch and add it to a list of paths
	private Stack findPath(Node node) {
		if(node.getChildren().isEmpty())
			return null;
		
		Stack pathStack = new Stack();
		ArrayList<Node> children = node.getChildren();
		for(Node n: children) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			
			pathStack.push(path);
			
			traversePath(n, pathStack);
		}
		
		
		return pathStack;
	}

	// method that traverses each branch of the tree
	private void traversePath(Node n, Stack pathStack) {
		ArrayList<Integer> current = (ArrayList<Integer>) pathStack.pop();
		
		if(n.getChildren().isEmpty()) {
			current.add(node.getValue());
			pathStack.push(current);
		}
		else {
			ArrayList<Node> children = node.getChildren();
			for(Node c: children) {
				ArrayList<Integer> path = (ArrayList<Integer>) current.clone();
				path.add(n.getValue());
				pathStack.push(path);
				traversePath(c, pathStack);
			}
		}
		
	}
	
	/*
	 * method that takes the branches of our tree and finds the one with the
	 * longest path
	 */
	private ArrayList<Integer> longestPath() {
		ArrayList<Integer> longest = new ArrayList<Integer>();
		int max = 0;
		
		for(ArrayList<Integer> list : paths) {
			int sum = list.size();
			if(sum > max)
				longest = list;
		}
		
		return longest;
	}
	
	// this will print the longest path distance and the steps it took
	private void printList(ArrayList<Integer> path) {
		System.out.println(path.size()-1);
		for(int i=1; i < path.size(); i++)
			System.out.println(path.get(i));
	}

	// method that finds the maximum value in a an array list
	private int findMax(ArrayList<Integer> list) {
		int max = 0;
		
		for(int i: list) {
			if(i > max)
				max = i;
		}
		return max;
	}

}
