// William Faunce
// Class Tradebook that is derived from Book

public class Tradebook extends Book {
	private String major;
	private final double MARKUP = 0.15;

	// constructor for empty tradebook
	public Tradebook() {
		super();
		major = "";
	}

	// constructor for parameterized tradebook
	public Tradebook(String bookTitle, String bookAuthor, String bookIsbn, double bookPrice, String classMajor) {
		super(bookTitle, bookAuthor, bookIsbn, bookPrice);
		major = classMajor;
	}

	// POST: returns major associated with the tradebook
	public String getMajor() {
		return major;
	}

	// POST: assigns a new major
	public void setMajor(String newMajor) {
		major = newMajor;
	}

	// POST: returns price after adding markup to base price
	public double retailPrice() {
		return price + (price * MARKUP);
	}

	// Returns the title, author, and then retail price of the tradebook
	public void getBookInfo() {
		System.out.printf("\n %-55s %-20s %7s", this.title, this.author, format.format(this.retailPrice()));
	}
}
