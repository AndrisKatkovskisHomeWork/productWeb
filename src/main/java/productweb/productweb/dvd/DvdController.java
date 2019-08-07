package productweb.productweb.dvd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DvdController {

    @Autowired
    DvdService dvdService;

    @RequestMapping("/DVD")
    public String DVD() {
        return "DVD";
    }

    @RequestMapping(value = {"dvdAdd"}, method = RequestMethod.GET)
    public String showAllDvds() {
        return "dvdAdd";
    }

    @RequestMapping(value = "/dvdAdd", method = RequestMethod.POST)
    public String addDvd(@ModelAttribute Dvd dvd) {
        this.dvdService.addDvd(dvd);
        return "dvdAdd";
    }

}