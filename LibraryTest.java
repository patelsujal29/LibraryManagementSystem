package LibraryManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("12345", "Clean Code", "Robert C. Martin", 2008);
        book2 = new Book("67890", "Effective Java", "Joshua Bloch", 2018);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("11223", "The Pragmatic Programmer", "Andrew Hunt", 1999);
        library.addBook(book3);
        assertEquals(3, library.viewAvailableBooks().size());
    }

    @Test
    public void testBorrowBook() throws Exception {
        library.borrowBook("12345");
        List<Book> availableBooks = library.viewAvailableBooks();
        assertFalse(book1.isAvailable());
        assertEquals(1, availableBooks.size()); // Only one book is available now
    }

    @Test
    public void testReturnBook() throws Exception {
        library.borrowBook("12345");
        library.returnBook("12345");
        assertTrue(book1.isAvailable());
    }

    @Test
    public void testViewAvailableBooks() {
        List<Book> availableBooks = library.viewAvailableBooks();
        assertEquals(2, availableBooks.size()); // Both books are available initially
    }

    @Test
    public void testBorrowNonAvailableBook() {
        Exception exception = assertThrows(Exception.class, () -> {
            library.borrowBook("11111"); // Book doesn't exist
        });
        assertEquals("Book is not available or doesn't exist.", exception.getMessage());
    }

    @Test
    public void testReturnNonBorrowedBook() {
        Exception exception = assertThrows(Exception.class, () -> {
            library.returnBook("67890"); // Book hasn't been borrowed yet
        });
        assertEquals("Book wasn't borrowed or doesn't exist.", exception.getMessage());
    }
}
