package rainbow.aop.aroundAdvice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by pengfei on 2017/9/15.
 */
public class AroundAdvice {

    public static void main(String[] args) {
        MessageInfo target = new MessageInfo();
        MessageInfoAdvice advice = new MessageInfoAdvice();
        ProxyFactory factory = new ProxyFactory();

        factory.setTarget(target);
        factory.addAdvice(advice);
        MessageInfo proxyObj = (MessageInfo) factory.getProxy();

        proxyObj.info();


    }
}

class MessageInfoAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before method");
        Object obj = methodInvocation.proceed();
        System.out.println("after method");

        return obj;
    }
}


class MessageInfo {
    public void info() {
        System.out.println("message info");
    }
}

