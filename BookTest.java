package LibraryManagementSystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("12345", "Clean Code", "Robert C. Martin", 2008);
        assertEquals("12345", book.getIsbn());
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals(2008, book.getPublicationYear());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBookAvailability() {
        Book book = new Book("12345", "Clean Code", "Robert C. Martin", 2008);
        assertTrue(book.isAvailable());
        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }
}