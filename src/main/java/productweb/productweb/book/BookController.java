package productweb.productweb.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = {"bookAdd"}, method = RequestMethod.GET)
    public String showAllBooks() {
        return "bookAdd";
    }

    @RequestMapping(value = "/bookAdd", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book) {
        this.bookService.addBook(book);
        return "bookAdd";
    }

    @RequestMapping(value = {"bookList"}, method = RequestMethod.GET)
    public String getAllBooks(Model model) {
        model.addAttribute("books", this.bookService.getAllBooks());
        return "bookList";
    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id, Model model) {
        boolean isDeleted = bookService.deleteBook(id);
        if (!isDeleted) {
            model.addAttribute("errorDeleteBook", "error deleting book!");
        }
        this.bookService.deleteBook(id);
        model.addAttribute("books", this.bookService.getAllBooks());
        return "bookList";
    }
}