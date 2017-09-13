package designPattern.visitor;

import designPattern.command.Command;

/**
 * Created by pengfei on 2017/9/10.
 */
public class VisitorTest {

    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.accept(new VisitorImpl());
    }
}
