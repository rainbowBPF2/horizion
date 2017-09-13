package designPattern.command;

/**
 * Created by pengfei on 2017/9/10.
 */
public class TestCommand {

    public static void main(String[] args) {
        Stock jp = new Stock("JP", 1000, "BHBT");
        BuyStockCommand buyCommand = new BuyStockCommand(jp, 50);
        SellStockCommand sellCommand = new SellStockCommand(jp, 100);

        Broker broker = new Broker();
        broker.addCommand(buyCommand);
        broker.addCommand(sellCommand);

        broker.placeOrder();

    }
}
