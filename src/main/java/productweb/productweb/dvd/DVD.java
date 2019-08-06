package productweb.productweb.dvd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DVD {

    @RequestMapping("/DVD")
    public String insurance() {
        return "DVD";
    }

}