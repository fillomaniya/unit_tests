package homework4;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    List<Book> bookList;

    @BeforeEach
    void testInit() {
        bookList = Arrays.asList(
                new Book("1", "Title1", "Author1"),
                new Book("2", "Title2", "Author2"),
                new Book("3", "Title3", "Author3"),
                new Book("4", "Title4", "Author4"),
                new Book("5", "Title5", "Author5")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void testGetBookById(String id) {
        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);

        when(bookRepository.findById(id)).thenReturn(bookList.get(Integer.parseInt(id) - 1));

        BookService bookService = new BookService(bookRepository);

        assertEquals(String.format("Book{id='%1$s', title='Title%1$s', author='Author%1$s'}", id), bookService.findBookById(id).toString());
    }

    @Test
    void testFindAllBooks() {
        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);

        when(bookRepository.findAll()).thenReturn(bookList);

        BookService bookService = new BookService(bookRepository);

        assertEquals(bookList, bookService.findAllBooks());
    }
}