package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List itemsWithDetail = loadAllItemsInfo(barcodes);
        Receipt receipt = calculateReceipt(itemsWithDetail);
        String receiptMessage = createReceipt(receipt);
        return receiptMessage;
    }

    private String createReceipt(Receipt receipt) {
        String receiptMessage = "***<store earning no money>Receipt***\n";

        for (Item item : receipt.getItemDetail()) {
            receiptMessage += "Name: " + item.getName()
                    + ", Quantity: " + item.getQuantity()
                    + ", Unit price: " + item.getPrice() + " (yuan)"
                    + ", Subtotal: " + item.getSubtotal() + " (yuan)"
                    + "\n";
        }
        receiptMessage += "----------------------\n"
                + "Total: " + receipt.getTotalPrice() + " (yuan)\n"
                + "**********************";

        return receiptMessage;
    }

    private Receipt calculateReceipt(List itemsWithDetail) {
        List itemsWithSubTotal = calculateSubTotal(itemsWithDetail);
        int totalPrice = calculateTotal(itemsWithSubTotal);
        Receipt receipt = new Receipt(itemsWithSubTotal,totalPrice);
        return receipt;
    }

    private int calculateTotal(List<Item> itemsWithSubTotal) {
        int totalPrice = 0;
        for(Item item : itemsWithSubTotal){
            totalPrice += item.getSubtotal();
        }
        return totalPrice;
    }

    private List calculateSubTotal(List<Item> itemsWithDetail) {
        List<Item> itemWithSubtotal = itemsWithDetail.stream().collect(Collectors.toList());

        for( Item subtotal : itemWithSubtotal){
            subtotal.setSubtotal(subtotal.getPrice(),subtotal.getQuantity());
        }

        return itemWithSubtotal;
    }

    private List loadAllItemsInfo(List<String> barcodes) {
        List<Item> itemWithDetails = new ArrayList<Item>();
        List<String> distinctBarCodes = new ArrayList<>();
        distinctBarCodes = barcodes.stream()
                .distinct()
                .collect(Collectors.toList());

        for (String barcode : distinctBarCodes){
            ItemInfo itemInfo = ItemDataLoader.loadAllItemInfos().stream()
                    .filter( b -> b.getBarcode().equals(barcode))
                    .findFirst().get();

            itemWithDetails.add(new Item(itemInfo.getName(), itemInfo.getPrice(), Collections.frequency(barcodes,barcode),0 ));
        }
        return itemWithDetails;
    }
}
