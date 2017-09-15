package rainbow.aop.jdkProxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by pengfei on 2017/9/15.
 */
public interface Message {
    public void info();
}

class MessageImpl implements Message{
    public void info() {
        System.out.println("Message info");
    }
}

class MessageAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before message");

    }
}