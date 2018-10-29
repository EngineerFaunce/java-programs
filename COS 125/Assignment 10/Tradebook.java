// William Faunce
// Class Tradebook that is derived from Book

package bookProgram;

public class Tradebook extends Book {
	private String major;
	private double retailPrice;
	private final double MARKUP = 0.15;
	
	// constructor for empty tradebook
	public Tradebook() {
		super();
		major = "";
		retailPrice = 0.00;
	}
	
	// constructor for parameterized tradebook
	public Tradebook(String bookTitle, String bookAuthor, int bookIsbn, double bookPrice, String classMajor, double retailPr) {
		super(bookTitle, bookAuthor, bookIsbn, bookPrice);
		major = classMajor;
		retailPrice = retailPr;
	}
	
	// POST: returns major associated with the tradebook
	public String getMajor() {
		return major;
	}
	
	// POST: returns retail price
	public double getRetailPrice() {
		return retailPrice;
	}
	
	// POST: assigns a new major
	public void setMajor(String newMajor) {
		major = newMajor;
	}
	
	// POST: assigns a new retail price
	public void setRetailPrice(double newRP) {
		retailPrice = newRP;
	}
	
	// POST: returns price after adding markup to base price
	public double retailPrice() {
		double markup = price * MARKUP;
		double retailPrice = price + markup;
		return retailPrice;
	}
}
