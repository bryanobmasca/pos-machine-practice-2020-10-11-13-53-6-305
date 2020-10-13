package pos.machine;

class Item extends ItemInfo{
    private final int quantity;
    private int subtotal;
    public Item(String barcode, String name, int price, int quantity) {
        super(barcode, name, price);
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public int setSubtotal(){
        return getPrice() * quantity;
    }

    public int getSubtotal(){
        return subtotal;
    }

}
