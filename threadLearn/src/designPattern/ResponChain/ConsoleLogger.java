package designPattern.ResponChain;

/**
 * Created by pengfei on 2017/9/4.
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    public void write(String message) {
        System.out.println("message:" + message);
    }
}
