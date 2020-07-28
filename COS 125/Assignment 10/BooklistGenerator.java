import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BooklistGenerator {
    public Book[] booklist; // array that contains Book objects

    public BooklistGenerator() {
        booklist = new Book[50];
    }

    /*
     * Reads in data from books.txt. Assumes that data will be read in the following
     * order: 1. Title 2. Author 3. ISBN 4. Wholesale price 5. Course ID (e.g.
     * COS125) or Major (COS)
     */
    public void LoadData() throws IOException {
        Scanner filescan = new Scanner(new FileReader("books.txt")); // scanner for reading books.txt

        String check;
        int counter = 0;

        while (filescan.hasNext() && counter < 50) {
            // Checking whether the book is a Textbook or a Tradebook
            check = filescan.nextLine();

            if (check.equals("Textbook")) {
                Textbook book = new Textbook();

                book.setTitle(filescan.nextLine());
                book.setAuthor(filescan.nextLine());
                book.setIsbn(filescan.nextLine());
                book.setPrice(Double.parseDouble(filescan.nextLine()));
                book.setCourseID(filescan.nextLine());

                booklist[counter] = book;
                counter++;
            } else if (check.equals("Tradebook")) {
                Tradebook trBook = new Tradebook();

                trBook.setTitle(filescan.nextLine());
                trBook.setAuthor(filescan.nextLine());
                trBook.setIsbn(filescan.nextLine());
                trBook.setPrice(Double.parseDouble(filescan.nextLine()));
                trBook.setMajor(filescan.nextLine());

                booklist[counter] = trBook;
                counter++;
            } else {
                System.out.println("Error reading input from file. Expected 'Textbook' or 'Tradebook', got " + check);
                System.exit(1);
            }
        }

        filescan.close();

    }
}