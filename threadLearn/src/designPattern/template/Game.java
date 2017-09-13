package designPattern.template;

/**
 * Created by pengfei on 2017/9/10.
 */
public abstract class Game {
    abstract void start();
    abstract void execute();
    abstract void end();// 随意扩展


    public final void play(){//程序模板
        start();
        execute();
        end();
    }
}
