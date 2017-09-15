package rainbow.aop.beforeAdvice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by pengfei on 2017/9/15.
 */
public class Message {

    public static void main(String[] args) {
        MessageInfo target=new MessageInfo();
        MessageAdvice advice=new MessageAdvice();
        ProxyFactory factory=new ProxyFactory();

        factory.setTarget(target);
        factory.addAdvice(advice);

        MessageInfo proxyObj= (MessageInfo) factory.getProxy();

        proxyObj.message();

    }
}

class MessageAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method:"+method.getName());
    }
}

class MessageInfo{
    public void message(){
        System.out.println("Message info:");
    }
}
