package productweb.productweb.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/deleteFurnitureAll", method = RequestMethod.GET)
    public String deleteFurniture(Model model, HttpServletRequest request) {
        if (request.getQueryString() != null) {
            String queryText = request.getQueryString();
            System.out.println(queryText);
            queryText = queryText.replaceAll("&", "");
            System.out.println(queryText);
            String[] checkBoxesIds = queryText.split("checkboxFurniture=");

            for (int i = 1; i < checkBoxesIds.length; i++) {
                boolean isDeleted = furnitureService.deleteFurniture(Integer.parseInt(checkBoxesIds[i]));
                if (!isDeleted) {
                    model.addAttribute("errorDeleteFurnitureAll", "error deleting selected furnitures!");
                }
                this.furnitureService.deleteFurniture(Integer.parseInt(checkBoxesIds[i]));
            }
        }
        model.addAttribute("furnitures", this.furnitureService.getAllFurnitures());
        return "furnitureList";
    }
}