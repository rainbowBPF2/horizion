package designPattern.command;

/**
 * Created by pengfei on 2017/9/10.
 */
public class BuyStockCommand implements Command{
    private Stock stock;
    private int transactionNum;

    public BuyStockCommand(Stock stock,int transactionNum){
        this.stock=stock;
        this.transactionNum=transactionNum;
    }

    @Override
    public void execute() {
        this.stock.buy(transactionNum);
    }
}
