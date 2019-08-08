package productweb.productweb.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book getBook(int id) {
        return bookRepository.findById(id).get();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public boolean deleteBook(int id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}