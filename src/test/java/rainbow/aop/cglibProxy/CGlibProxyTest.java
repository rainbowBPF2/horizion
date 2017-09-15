package rainbow.aop.cglibProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import rainbow.aop.jdkProxy.Message;

/**
 * Created by pengfei on 2017/9/15.
 */
public class CGlibProxyTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:cglibProxy.xml");

        Message proxyObj= (Message) context.getBean("cglibProxyFactoryBean");
        proxyObj.info();

    }
}
