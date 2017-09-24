package controller;

import domain.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pengfei on 2017/9/22.
 */
@Controller
public class LoginController {

    private final static Logger logger=Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String get(){
        logger.info("Inside login get method");
        return "home";
    }

    //public String login(@RequestParam("name") String name, String password, ModelMap model){
    //public String login(String name, String password, ModelMap model){

    @RequestMapping(value = "/loginHere",method=RequestMethod.POST)
    public String login(@RequestParam("name") String name, String password, ModelMap model){
        logger.info("Login controller begin service");

        model.addAttribute("password",password);
        model.addAttribute("name",name);

        if(password==null)
            throw new RuntimeException("Password should not be null!");

        logger.info("Login controller end service!");

        return "homePage";
    }

    @RequestMapping(value="/toLoginPage",method = RequestMethod.GET)
    public String redirect(){
        return "redirect:login";
    }

    @RequestMapping(value = "/visitStaticPage",method = RequestMethod.GET)
    public String visitStaticPage(){

        return "redirect:/pages/static.html";
    }


}
