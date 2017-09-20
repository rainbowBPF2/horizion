package algorithm;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by pengfei on 2017/9/19.
 */
public class MiniStack {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MiniStack(){
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
    }

    public void push(int data){
        s1.push(data);

        if(s2.isEmpty()||s2.peek()>data)
            s2.push(data);
        else
            s2.push(s2.peek());
    }


    public int pop(){
        if(s1.isEmpty()||s2.isEmpty())
            throw new EmptyStackException();

        s2.pop();

        return s1.pop();
    }

    public int min(){
        if(s2.isEmpty())
            throw new EmptyStackException();
        return s2.peek();
    }




}
