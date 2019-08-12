package productweb.productweb.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/deleteBookAll", method = RequestMethod.GET)
    public String deleteBookAll(Model model, HttpServletRequest request) {
        if (request.getQueryString() != null) {
            String queryText = request.getQueryString();
            System.out.println(queryText);
            queryText = queryText.replaceAll("&", "");
            System.out.println(queryText);
            String[] checkBoxesIds = queryText.split("checkboxBook=");

            for (int i = 1; i < checkBoxesIds.length; i++) {
                boolean isDeleted = bookService.deleteBook(Integer.parseInt(checkBoxesIds[i]));
                if (!isDeleted) {
                    model.addAttribute("errorDeleteBookAll", "error deleting selected books!");
                }
                this.bookService.deleteBook(Integer.parseInt(checkBoxesIds[i]));
            }
        }
        model.addAttribute("books", this.bookService.getAllBooks());
        return "bookList";
    }
}