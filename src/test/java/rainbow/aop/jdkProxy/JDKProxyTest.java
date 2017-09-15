package rainbow.aop.jdkProxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pengfei on 2017/9/15.
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:jdkProxy.xml");

        Message proxyObj= (Message) context.getBean("jdkProxyFactoryBean");
        proxyObj.info();

    }
}
