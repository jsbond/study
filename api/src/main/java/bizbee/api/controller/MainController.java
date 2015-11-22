package bizbee.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCompaniesForPartner()  {

        return "main";
    }
}
