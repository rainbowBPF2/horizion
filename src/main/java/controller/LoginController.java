package controller;

import com.alibaba.fastjson.JSON;
import domain.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
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
        if(currentUser!=null){
            logger.info("Current User:" + currentUser.getName());
        }

        return "homePage";
    }

    //public String login(@RequestParam("name") String name, String password, ModelMap model){
    //public String login(String name, String password, ModelMap model){

    @RequestMapping(value = "/loginHere")
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

            return "redirect:/homePage";
        } else {
            return "redirect:/index.jsp";
        }
    }

    @RequestMapping(value = "/toIndexPage", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/visitStaticPage", method = RequestMethod.GET)
    public String visitStaticPage() {

        return "redirect:/pages/static.html";
    }


    //Return to previous path
    @ResponseBody
    @RequestMapping(value = "/getUserSession")
    public String getUserSession( HttpSession session) {
        String result="";

        Object  obj=session.getAttribute("user");
        if (obj instanceof String){
            result= (String) obj;
        }else if (obj instanceof UserInfo){
            result=((UserInfo) obj).getName();
        }

        result= JSON.toJSONString(result);

        return result;
    }

    @RequestMapping("/logOut")
    @ResponseBody
    public String logout( SessionStatus status){
        status.setComplete();
        return "logout";
    }

    @RequestMapping(value = "/toRegisterPage")
    public String toRegisterPage(){
        return "account/accountRegister";
    }

}
