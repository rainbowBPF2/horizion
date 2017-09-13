package designPattern.proxyPattern;

/**
 * Created by pengfei on 2017/9/4.
 */
public class TestImage {

    public static void main(String[] args) {
        Image image=new ProxyImage("testfile");

        image.display();

        System.out.println("internal sleep");

        image.display();
    }
}
