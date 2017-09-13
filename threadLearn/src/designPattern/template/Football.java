package designPattern.template;

/**
 * Created by pengfei on 2017/9/10.
 */
public class Football extends Game {

    @Override
    void start() {
        System.out.println("Football start");
    }

    @Override
    void execute() {
        System.out.println("Football execute");
    }

    @Override
    void end() {
        System.out.println("Football end");
    }
}
