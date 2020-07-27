import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BooklistGenerator {

    public static void main(String[] args) throws IOException {
        Scanner filescan = new Scanner(new FileReader("books.txt")); // scanner for scanning files
        NumberFormat price = new DecimalFormat("$0.00"); // format for adding a $ sign for pricing

        Book[] booklist = new Book[50];

        while (filescan.hasNext()) {
            /*
             * We have an array of type Book. Books have their own attributes.
             * 
             * We will have to read the data from books.txt
             * 
             * The first line for a book indicates if it is a Textbook or Tradebook. Every
             * successive line is data for that book.
             * 
             * So we just need to check what type of book is being read and then use the
             * constructor for the relevant book. After constructing the book we will add it
             * to the booklist array.
             */
            if (filescan.next().equals("Textbook")) {

            }
        }

        filescan.close();

    }
}