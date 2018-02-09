package controller;

import domain.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.LoginService;

import javax.servlet.http.HttpSession;

/**
 * Created by pengfei on 2017/9/22.
 */
@Controller
@SessionAttributes("user")
public class LoginController {

    private final static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/homePage")
    public String get(HttpSession session) {
        logger.info("Inside login get method");

        UserInfo currentUser = (UserInfo) session.getAttribute("user");
        logger.info("Current User:" + currentUser.getName());

        return "homePage";
    }

    //public String login(@RequestParam("name") String name, String password, ModelMap model){
    //public String login(String name, String password, ModelMap model){

    @RequestMapping(value = "/loginHere", method = RequestMethod.POST)
    public String login(@RequestParam("name") String name, String password, ModelMap model) {
        logger.info("Login controller begin service");

        UserInfo user = new UserInfo();
        user.setName(name);
        user.setPassword(password);

        model.addAttribute("bean", user);

        if (loginService.checkUserAccess(name, password)) {
            logger.info("Login controller end service!");

            user.setPassword("");
            model.addAttribute("user", user);

            return "redirect:homePage";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/toLoginPage", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:login";
    }

    @RequestMapping(value = "/visitStaticPage", method = RequestMethod.GET)
    public String visitStaticPage() {

        return "redirect:/pages/static.html";
    }


}
