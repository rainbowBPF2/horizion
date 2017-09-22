package controller;

import domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;

/**
 * Created by pengfei on 2017/9/3.
 */

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/hello")
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView("hello");
        UserInfo user = userService.getUserInfo(3);
        mv.addObject("message", user.getComment());
        return mv;
    }

}
