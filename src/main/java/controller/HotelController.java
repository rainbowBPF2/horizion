package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pengfei on 2017/9/24.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    private static final Logger logger=Logger.getLogger(HotelController.class);

    @RequestMapping("/home")
    public String visitHome(ModelMap model){
        logger.info("Visiting hotel home page!");

        System.out.println("hotel home!");

        return "hotel/hotelHome";
    }
}
