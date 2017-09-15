package rainbow;

import Utility.RedisCache;
import dao.UserDao;
import dao.UserDaoImpl;
import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;
import service.UserService;
import service.UserServiceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by pengfei on 2017/9/13.
 */
@Repository
@Service
@Component("annotation")
@Controller
@Resource(name="annotationTool")
public class Annotation1 {


    @Autowired(required = false)
    private int age;

    @Resource(name="redisCache2")
    private RedisCache cache;

    @Required
    public void setAge(int age) {
        this.age = age;
    }

    @Autowired(required = false)
    private UserService service;

    @Autowired
    @Qualifier("userDAO2")
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }

    @Autowired
    @Resource(type = UserServiceImpl.class)
    public void testUserService(UserService userService){
        System.out.println("Auto wired user service");
    }

    @Bean
    @Scope("singleton")
    public UserInfo test(){
        return new UserInfo();
    }

    @PostConstruct
    public void preInit(){

    }


    @PreDestroy
    public void preDestroy(){

    }


}
