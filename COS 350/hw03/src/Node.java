
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Node {
	private int value;
	private int parent;
	private ArrayList<Node> children = new ArrayList<Node>();
	
	public Node() {
		this.value = 0;
		this.parent = 0;
	}
	
	public Node(int v, int p) {
		this.value = v;
		this.parent = p;
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	public void setValue(int v) {
		this.value = v;
	}
	
	public void setParent(int p) {
		this.parent = p;
	}
	
	public void setChildren(ArrayList<Node> c) {
		this.children = c;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getParent() {
		return this.value;
	}
	
	public ArrayList<Node> getChildren() {
		return this.children;
	}
	
	public void display() {
		System.out.println("Node: " +value+ " Parrent: " +parent);
	}
	
}
