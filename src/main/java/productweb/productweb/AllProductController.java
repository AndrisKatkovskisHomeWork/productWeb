package productweb.productweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import productweb.productweb.book.BookService;
import productweb.productweb.dvd.DvdService;
import productweb.productweb.furniture.FurnitureService;

@Controller
public class AllProductController {

    @Autowired
    DvdService dvdService;

    @Autowired
    BookService bookService;

    @Autowired
    FurnitureService furnitureService;

    @RequestMapping("/allExistingProductList")
    public String allExistingProductList() {
        return "allExistingProductList";
    }

    @RequestMapping("/productAdd")
    public String productAdd() {
        return "productAdd";
    }

    @RequestMapping(value = {"allExistingProductList"}, method = RequestMethod.GET)
    public String getAllDvds(Model model) {
        getAllDvdBookFurniture(model);
        return "allExistingProductList";
    }

    private void getAllDvdBookFurniture(Model model) {
        model.addAttribute("dvds", this.dvdService.getAllDvds());
        model.addAttribute("books", this.bookService.getAllBooks());
        model.addAttribute("furnitures", this.furnitureService.getAllFurnitures());
    }

    @RequestMapping(value = "/deleteDvd/{id}", method = RequestMethod.GET)
    public String deleteDvd(@PathVariable int id, Model model) {
        boolean isDeleted = dvdService.deleteDvd(id);
        if (!isDeleted) {
            model.addAttribute("errorDeleteDvd", "error deleting dvd!");
        }
        this.dvdService.deleteDvd(id);
        model.addAttribute("dvds", this.dvdService.getAllDvds());
        return "redirect:/allExistingProductList";
    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id, Model model) {
        boolean isDeleted = bookService.deleteBook(id);
        if (!isDeleted) {
            model.addAttribute("errorDeleteBook", "error deleting book!");
        }
        this.bookService.deleteBook(id);
        getAllDvdBookFurniture(model);
        return "redirect:/allExistingProductList";
    }

    @RequestMapping(value = "/deleteFurniture/{id}", method = RequestMethod.GET)
    public String deleteFurniture(@PathVariable int id, Model model) {
        boolean isDeleted = furnitureService.deleteFurniture(id);
        if (!isDeleted) {
            model.addAttribute("errorDeleteFurniture", "error deleting furniture!");
        }
        this.furnitureService.deleteFurniture(id);
        getAllDvdBookFurniture(model);
        return "redirect:/allExistingProductList";
    }

}