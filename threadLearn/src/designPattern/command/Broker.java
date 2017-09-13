package designPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfei on 2017/9/10.
 */
public class Broker {
    private List<Command> list=new ArrayList<>();

    public void addCommand(Command command){
        list.add(command);
    }

    public void placeOrder(){
        for(Command c:list)
            c.execute();
    }


}
