package rainbow.aop.afterAdvice;


import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by pengfei on 2017/9/15.
 */
public class AfterAdvice {
    public static void main(String[] args) {
        MessageInfo target=new MessageInfo();
        MessageAfterAdvice advice=new MessageAfterAdvice();
        ProxyFactory factory=new ProxyFactory();

        factory.setTarget(target);
        factory.addAdvice(advice);
        MessageInfo proxyObj= (MessageInfo) factory.getProxy();

        proxyObj.info();

    }
}

class MessageAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after advice");
    }
}

class MessageInfo {
    public void info(){
        System.out.println("Message info");
    }
}