// William Faunce
// Base class for creating book objects

public abstract class Book {
	protected String title; // title of book
	protected String author; // author of book
	protected String isbn; // ISBN of book
	protected double price; // wholesale price of book

	// default constructor for a book
	public Book() {
		title = "";
		author = "";
		isbn = "";
		price = 0.00;
	}

	// parameterized constructor for a book
	public Book(String bookTitle, String bookAuthor, String bookIsbn, double bookPrice) {
		title = bookTitle;
		author = bookAuthor;
		isbn = bookIsbn;
		price = bookPrice;
	}

	// POST: returns title
	public String getTitle() {
		return title;
	}

	// POST: returns author
	public String getAuthor() {
		return author;
	}

	// POST: returns isbn number
	public String getIsbn() {
		return isbn;
	}

	// POST: returns price
	public double getPrice() {
		return price;
	}

	// POST: sets a new title
	public void setTitle(String newTitle) {
		title = newTitle;
	}

	// POST: sets a new author
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}

	// POST: sets a new isbn
	public void setIsbn(String newIsbn) {
		isbn = newIsbn;
	}

	// POST: sets a new price
	public void setPrice(double newPrice) {
		price = newPrice;
	}

	public abstract double retailPrice();
}
