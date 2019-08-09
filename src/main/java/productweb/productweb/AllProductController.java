package productweb.productweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("dvds", this.dvdService.getAllDvds());
        model.addAttribute("books", this.bookService.getAllBooks());
        model.addAttribute("furnitures", this.furnitureService.getAllFurnitures());
        return "allExistingProductList";
    }

}