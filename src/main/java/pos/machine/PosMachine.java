package pos.machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List itemsWithDetail = loadAllItemsInfo(barcodes);
        Receipt receipt = calculateReceipt(itemsWithDetail);
        return null;
    }

    private Receipt calculateReceipt(List itemsWithDetail) {
        List itemsWithSubTotal = calculateSubTotal(itemsWithDetail);
        return null;
    }

    private List calculateSubTotal(List itemsWithDetail) {
        List<Item> itemWithSubtotal = new ArrayList<>();

        return null;
    }

    private List loadAllItemsInfo(List<String> barcodes) {
        List<Item> itemWithDetails = new ArrayList<>();
        List<String> distinctBarCodes = new ArrayList<>();
        distinctBarCodes = barcodes.stream()
                .distinct()
                .collect(Collectors.toList());

        for (String barcode : distinctBarCodes){
            ItemInfo itemInfo = ItemDataLoader.loadAllItemInfos().stream()
                    .filter( b -> b.getBarcode().equals(barcode))
                    .findFirst().get();

            itemWithDetails.add(new Item(barcode, itemInfo.getName(), itemInfo.getPrice(), Collections.frequency(barcodes,barcode)));
        }
        return itemWithDetails;
    }
}
