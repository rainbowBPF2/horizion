package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pengfei on 2017/9/24.
 */

@Controller
@RequestMapping("/domesticTicket")
public class DomesticTicketController {

    private final static Logger logger = Logger.getLogger(DomesticTicketController.class);

    @RequestMapping("/home")
    public String visitHome(@RequestParam(value = "userName") String userName, @RequestParam(value = "userID") Integer userID, ModelMap model) {
        logger.info("Visiting guest house home!");

        System.out.println(userID);
        System.out.println(userName);

        model.addAttribute("id", userID);
        model.addAttribute("name", userName);

        return "domesticTicket/domesticTicketHome";
    }

    @RequestMapping("/testHttpServlet")
    public String testHttpServlet(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        String name = request.getParameter("name");
        String id = request.getParameter("id");

        System.out.println(name);
        System.out.println(id);
        model.addAttribute("message", "Test http servlet success!");

        logger.info("Test http servlet success!");

        return "hello";
    }

    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID") String sessionID, ModelMap model) {
        logger.info("Getting session id with cookie value");

        System.out.println(sessionID);
        model.addAttribute("message", "Test cookie value success!");
        model.addAttribute("sessionID",sessionID);

        return "hello";
    }

}
