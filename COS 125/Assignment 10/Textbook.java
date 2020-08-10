// William Faunce
// Class Textbook that is derived from Book

public class Textbook extends Book {
	private String course;
	private final double MARKUP = 0.1;

	// default constructor
	public Textbook() {
		super();
		course = "";
	}

	// parameterized constructor
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

	// POST: prints out the course ID, book title, author, and retail price of a
	// textbook
	public void getBookInfo() {
		System.out.printf("\n %-6s %-55s %-20s %7s", this.course, this.title, this.author,
				format.format(this.retailPrice()));
	}

}
