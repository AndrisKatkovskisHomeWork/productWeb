package productweb.productweb.dvd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DvdController {

    @Autowired
    DvdService dvdService;

    @RequestMapping(value = {"dvdAdd"}, method = RequestMethod.GET)
    public String showAllDvds() {
        return "dvdAdd";
    }

    @RequestMapping(value = "/dvdAdd", method = RequestMethod.POST)
    public String addDvd(@ModelAttribute Dvd dvd) {
        this.dvdService.addDvd(dvd);
        return "dvdAdd";
    }

    @RequestMapping(value = {"dvdList"}, method = RequestMethod.GET)
    public String getAllDvds(Model model) {
        model.addAttribute("dvds", this.dvdService.getAllDvds());
        return "dvdList";
    }

    @RequestMapping(value = "/deleteDvdAll", method = RequestMethod.GET)
    public String deleteDvdAll(Model model, HttpServletRequest request) {
        if (request.getQueryString() != null) {
            String queryText = request.getQueryString();
            System.out.println(queryText);
            queryText = queryText.replaceAll("&", "");
            System.out.println(queryText);
            String[] checkBoxesIds = queryText.split("checkboxDVD=");

            for (int i = 1; i < checkBoxesIds.length; i++) {
                boolean isDeleted = dvdService.deleteDvd(Integer.parseInt(checkBoxesIds[i]));
                if (!isDeleted) {
                    model.addAttribute("errorDeleteDvdAll", "error deleting selected dvd!");
                }
                this.dvdService.deleteDvd(Integer.parseInt(checkBoxesIds[i]));
            }
        }
        model.addAttribute("dvds", this.dvdService.getAllDvds());
        return "dvdList";
    }
}