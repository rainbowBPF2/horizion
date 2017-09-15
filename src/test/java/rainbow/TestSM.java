package rainbow;

import Utility.RedisCache;
import domain.UserInfo;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import service.IUserService;
import service.UserService;

/**
 * Created by pengfei on 2017/9/2.
 */
public class TestSM {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:mybatis/application.xml");

        context=new FileSystemXmlApplicationContext();
        context=new AnnotationConfigApplicationContext();
        context=new AnnotationConfigWebApplicationContext();
        context=new XmlWebApplicationContext();

        BeanFactory factory=new XmlBeanFactory(new ClassPathResource("mybatis/application.xml"));
        UserService service= (UserService) factory.getBean("userService");


        summaryTest(context);

        ((AbstractApplicationContext)context).registerShutdownHook();

        System.exit(-1);
    }

    private static void testRedis(ApplicationContext context) {
        RedisCache cache = (RedisCache) context.getBean("redisCache");
        cache.set("linda", "linda run");
        String obj = (String) cache.get("linda");
        System.out.println(obj);


    }


    private static void summaryTest(ApplicationContext context) {
        UserInfo user = new UserInfo();
        user.setName("Elisabeth" + Math.random());
        user.setSalary(3999);
        user.setComment("Good employee");

        System.out.println("begin add");
        IUserService service = (IUserService) context.getBean("newUserService");
        service.addUser(user);

        System.out.println("begin query");
        UserInfo queryObj = service.queryUser(user);
        System.out.println(queryObj.getName());
//
//        System.out.println("begin delete");
//        service.deleteUser(user);

        System.out.println("begin query");
        UserInfo cacheUser = service.queryUser(user);
        System.out.println("Cache User name:" + cacheUser.getName());

        System.out.println("begin delete");
        service.deleteUser(user);

        System.out.println("begin query");
        UserInfo cacheUser2 = service.queryUser(user);
        System.out.println("Cache User name:" + cacheUser2.getName());
    }

    private static void queryUser(ApplicationContext context) {
        UserInfo user = new UserInfo();
        user.setId(1005);

        IUserService service = (IUserService) context.getBean("newUserService");

        UserInfo obj = service.queryUser(user);

        System.out.println("query name:" + obj.getName());
        System.out.println("query salary:" + obj.getSalary());

    }
}
