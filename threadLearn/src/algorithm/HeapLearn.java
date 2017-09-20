package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by pengfei on 2017/9/19.
 */
public class HeapLearn {
    public static void main(String[] args) {

    }

    private static void getPartialMax(){

        PriorityQueue queue=new PriorityQueue(10, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.val>o2.val)
                    return 1;
                else if(o1.val<o2.val)
                    return -1;
                else if(o1.index>o2.index)
                    return 1;
                else if(o1.index<o2.index)
                    return -1;
                return 0;
            }
        });

        Item item1=new Item(3,5);
        Item item2=new Item(8,5);
        Item item3=new Item(2,5);
        Item item4=new Item(4,5);

        queue.add(item1);
        queue.add(item2);
        queue.add(item3);
        queue.add(item4);

        queue.peek();
        queue.add(item1);
        Item peak= (Item) queue.poll();

        TreeMap<String,Integer> map=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Comparable<Object> com=new Comparable<Object>() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

    private class Idea{


        private void test() throws IOException {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String s=reader.readLine();
            System.out.println("first line:"+s);
            while(s!=null){
                s=reader.readLine();
                System.out.println("new line:"+s);
            }
        }
    }
}

class Item{
    int val;
    int index;

    public Item(int val,int index){
        this.val=val;
        this.index=index;
    }
}

