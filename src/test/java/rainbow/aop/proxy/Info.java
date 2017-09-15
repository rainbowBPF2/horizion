package rainbow.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pengfei on 2017/9/15.
 */
public interface Info {
    public void say();
}

class InfoImpl implements Info {

    public void say() {
        System.out.println("Info say");
    }
}

class InfoProxy implements InvocationHandler {

    private Object proxyObj;

    public Object bind(Object obj) {
        this.proxyObj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }



    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        login();
        Object object = method.invoke(this.proxyObj, args);
        logout();
        return object;
    }

    private void login() {
        System.out.println("log in");
    }

    private void logout() {
        System.out.println("log out");
    }


}