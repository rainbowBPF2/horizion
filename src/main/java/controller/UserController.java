package controller;

import com.alibaba.fastjson.JSON;
import domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/home/listUser")
    @ResponseBody
    public String getAllUser() {
        List list = new ArrayList<TestObj>();
       /* for (int i = 0; i < 105; i++) {

            int status=i%9;

            TestObj temp = new TestObj(Integer.toString(i), "name" + i, "price" + i,Integer.toString(status));

            list.add(temp);
        }*/

       List<UserInfo> userlist =this.userService.getUserList();

       for(UserInfo obj:userlist){
           TestObj test=new TestObj(obj.getId(),obj.getName(),obj.getSalary(),obj.getComment());
           list.add(test);
       }


        String resultJson= JSON.toJSONString(list);
        return resultJson;
    }


}

class TestObj {
    private int id;
    private String name;
    private double price;
    private String status;

    public TestObj(int id, String name, double price,String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}