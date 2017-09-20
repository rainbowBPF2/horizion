package algorithm;

import java.io.*;
import java.util.Stack;

/**
 * Created by pengfei on 2017/9/19.
 */
public class BufferLearn {
    public static void main(String[] args) throws IOException {
        Reader reader=new FileReader("");
        bufferReview();
    }

    private static void bufferReview() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine();
        System.out.println("first line:" + s);

        while (s != null) {
            s = reader.readLine();
            System.out.println("new line:" + s);
        }
    }

    private void stackLearn(){
        Stack<Character> stack=new Stack<>();



    }
}
