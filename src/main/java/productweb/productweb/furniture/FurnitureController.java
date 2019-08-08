package productweb.productweb.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FurnitureController {

    @Autowired
    FurnitureService furnitureService;

    @RequestMapping(value = {"furnitureAdd"}, method = RequestMethod.GET)
    public String showAllFurnitures() {
        return "furnitureAdd";
    }

    @RequestMapping(value = "/furnitureAdd", method = RequestMethod.POST)
    public String addFurniture(@ModelAttribute Furniture furniture) {
        this.furnitureService.addFurniture(furniture);
        return "furnitureAdd";
    }

    @RequestMapping(value = {"furnitureList"}, method = RequestMethod.GET)
    public String getAllFurnitures(Model model) {
        model.addAttribute("furnitures", this.furnitureService.getAllFurnitures());
        return "furnitureList";
    }

    @RequestMapping(value = "/deleteFurniture/{id}", method = RequestMethod.GET)
    public String deleteFurniture(@PathVariable int id, Model model) {
        boolean isDeleted = furnitureService.deleteFurniture(id);
        if (!isDeleted) {
            model.addAttribute("errorDeleteFurniture", "error deleting furniture!");
        }
        this.furnitureService.deleteFurniture(id);
        model.addAttribute("furnitures", this.furnitureService.getAllFurnitures());
        return "furnitureList";
    }
}