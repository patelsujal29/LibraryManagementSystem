package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Borrow a book by ISBN
    public void borrowBook(String isbn) throws Exception {
        Optional<Book> bookOpt = books.stream()
                .filter(book -> book.getIsbn().equals(isbn) && book.isAvailable())
                .findFirst();

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setAvailable(false);
        } else {
            //throw new Exception("Book is not available or doesn't exist.");
            System.err.println("Book is not available or doesn't exist.");
        }
    }

    // Return a book by ISBN
    public void returnBook(String isbn) throws Exception {
        Optional<Book> bookOpt = books.stream()
                .filter(book -> book.getIsbn().equals(isbn) && !book.isAvailable())
                .findFirst();

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setAvailable(true);
        } else {
            //throw new Exception("Book wasn't borrowed or doesn't exist.");
            System.err.println("Book wasn't borrowed or doesn't exist.");
        }
    }

    // View all available books
    public List<Book> viewAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
    
}
