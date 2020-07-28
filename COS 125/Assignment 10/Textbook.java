// William Faunce
// Class Textbook that is derived from Book

public class Textbook extends Book {
	private String course;
	private final double MARKUP = 0.1;

	// constructor for empty textbook
	public Textbook() {
		super();
		course = "";
	}

	// constructor for parameterized textbook
	public Textbook(String bookTitle, String bookAuthor, String bookIsbn, double bookPrice, String courseID) {
		super(bookTitle, bookAuthor, bookIsbn, bookPrice);
		course = courseID;
	}

	// POST: returns course ID associated with the textbook
	public String getCourseID() {
		return course;
	}

	// POST: assigns a new course ID
	public void setCourseID(String newCourse) {
		course = newCourse;
	}

	// POST: returns price after adding markup to base price
	public double retailPrice() {
		return price + (price * MARKUP);
	}

	public void getBookInfo() {
		System.out.print("Book title: " + this.title + "\nBook Author: " + this.author + "\nBook ISBN: " + this.isbn
				+ "\nBook Price (before markup): " + format.format(price) + "\n");
	}

}
