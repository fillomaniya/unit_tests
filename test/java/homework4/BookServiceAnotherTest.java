package homework4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceAnotherTest {

    InMemoryBookRepository bookRepositoryFake = new InMemoryBookRepository();

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void testGetBookById(String id) {

        BookService bookService = new BookService(bookRepositoryFake);

        assertEquals(bookRepositoryFake.findById(id).toString(), bookService.findBookById(id).toString());
    }

    @Test
    void testFindAllBooks() {

        BookService bookService = new BookService(bookRepositoryFake);

        assertEquals(bookRepositoryFake.findAll(), bookService.findAllBooks());
    }
}
