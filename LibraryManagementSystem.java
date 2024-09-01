package LibraryManagementSystem;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        try {
            // Step 1: Initialize the Library
            Library library = new Library();

            // Step 2: Add Books to the Library
            Book book1 = new Book("12345", "Clean Code", "Robert C. Martin", 2008);
            Book book2 = new Book("67890", "Effective Java", "Joshua Bloch", 2018);
            Book book3 = new Book("54321", "Design Patterns", "Erich Gamma", 1994);

            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);

            // Step 3: View Available Books
            System.out.println("Available books:");
            List<Book> availableBooks = library.viewAvailableBooks();
            availableBooks.forEach(System.out::println);

            // Step 4: Borrow a Book
            System.out.println("\nBorrowing 'Clean Code'...");
            library.borrowBook("12345");

            // Step 5: View Available Books After Borrowing
            System.out.println("\nAvailable books after borrowing 'Clean Code':");
            availableBooks = library.viewAvailableBooks();
            availableBooks.forEach(System.out::println);
            
            // Try to Borrow same book again
            System.out.println("\nTry to Borrow Book 'Clean Code' again:");
            library.borrowBook("12345");

            // Step 6: Return the Borrowed Book
            System.out.println("\nReturning 'Clean Code'...");
            library.returnBook("12345");

            // Step 7: View Available Books After Returning
            System.out.println("\nAvailable books after returning 'Clean Code':");
            availableBooks = library.viewAvailableBooks();
            availableBooks.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
