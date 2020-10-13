package pos.machine;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Item> itemDetail = new ArrayList<>();
    private int totalPrice;
    public Receipt(List<Item> itemDetail, int totalPrice){
        this.itemDetail = itemDetail;
        this.totalPrice = totalPrice;
    }

    public List<Item> getItemDetail(){
        return itemDetail;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}
