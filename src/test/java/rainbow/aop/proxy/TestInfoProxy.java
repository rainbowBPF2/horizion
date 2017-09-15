package rainbow.aop.proxy;

/**
 * Created by pengfei on 2017/9/15.
 */
public class TestInfoProxy {

    public static void main(String[] args) {

        InfoProxy proxy=new InfoProxy();
        Info info= (Info) proxy.bind(new InfoImpl());

        info.say();
    }
}
