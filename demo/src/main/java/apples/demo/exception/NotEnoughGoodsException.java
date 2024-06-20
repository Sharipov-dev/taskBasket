package apples.demo.exception;

public class NotEnoughGoodsException extends RuntimeException{

    public NotEnoughGoodsException(String goodName, int goodAmount, int requestedAmount){

        super(String.format("Not enough amount. Good name: %s. Desired amount: %s. In stock: %s ",
                goodName,
                String.valueOf(goodAmount),
                String.valueOf(requestedAmount)));
    }
}
