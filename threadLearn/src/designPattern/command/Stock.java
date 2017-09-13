package designPattern.command;

/**
 * Created by pengfei on 2017/9/10.
 */
public class Stock {

    private String name;
    private int number;
    private double price;
    private String owner;
    private String releaseBody;

    public Stock(String name, int number, String owner) {
        this.name = name;
        this.number = number;
        this.owner = owner;
    }

    public Stock() {

    }

    public void buy(int size) {
        System.out.println("buy " + name + " " + size);
    }

    public void sell(int size) {
        System.out.println("sell " + name + " " + size);
    }


}
