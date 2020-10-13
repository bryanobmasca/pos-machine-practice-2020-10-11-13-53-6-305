package pos.machine;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<String> itemDetail = new ArrayList<>();
    private double totalPrice;
    public Receipt(List<String> itemDetail, double totalPrice){
        this.itemDetail = itemDetail;
        this.totalPrice = totalPrice;
    }

    public List<String> getItemDetail(){
        return itemDetail;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
