package jvm;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pengfei on 2017/9/7.
 */
public class ProxyTest {

    public static void main(String[] args) {

        Hello obj = (Hello) new ProxyHello().bind(new SayHello());
        obj.say();

    }

}

interface Hello {
    public void say();
}

class SayHello implements Hello {
    @Override
    public void say() {
        System.out.println("Say:say hello");
    }
}

class ProxyHello implements InvocationHandler {
    Object obj;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Welcome proxy world");
        return method.invoke(obj, args);
    }
}