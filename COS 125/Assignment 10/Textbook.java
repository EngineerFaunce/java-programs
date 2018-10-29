// William Faunce
// Class Textbook that is derived from Book

package bookProgram;

public class Textbook extends Book {
	private String course;
	private double retailPrice;
	private final double MARKUP = 0.1;
	
	// constructor for empty textbook
	public Textbook() {
		super();
		course = "";
		retailPrice = 0.00;
	}
	
	// constructor for parameterized textbook
	public Textbook(String bookTitle, String bookAuthor, int bookIsbn, double bookPrice, String courseID, double retailPr) {
		super(bookTitle, bookAuthor, bookIsbn, bookPrice);
		course = courseID;
		retailPrice = retailPr;
	}
	
	// POST: returns course ID associated with the textbook
	public String getCourseID() {
		return course;
	}
	
	// POST: returns retail price
	public double getRetailPrice() {
		return retailPrice;
	}
	
	// POST: assigns a new course ID
	public void setCourseID(String newCourse) {
		course = newCourse;
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
