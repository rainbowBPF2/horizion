package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pengfei on 2017/9/24.
 */


@Controller
@RequestMapping("/guestHouse")
public class GuestHouseController {

    private final static Logger logger=Logger.getLogger(GuestHouseController.class);

    @RequestMapping("/home/{id}")
    public String visitHome(@PathVariable("id") Integer id, ModelMap model){
        logger.info("Visiting guest house home!");

        System.out.println(id);
        model.addAttribute("id",id);

        return "guestHouse/guestHome";
    }

}
