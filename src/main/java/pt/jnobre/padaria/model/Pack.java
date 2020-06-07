package pt.jnobre.padaria.model;

public class Pack implements Comparable<Pack> {

    private int quantity;
    private float price;
    private Code codeProduct;

    public Pack(int quantity, float price, Code codeProduct) {
        this.quantity = quantity;
        this.price = price;
        this.codeProduct = codeProduct;
    }

    public Pack() { }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Code getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Code codeProduct) {
        this.codeProduct = codeProduct;
    }

    @Override
    public int compareTo(Pack o) {
        int x1 = quantity;
        int x2 = o.getQuantity();
        if (x1 < x2) {
            return -1;
        } else if (x1 == x2) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Pack{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", codeProduct=" + codeProduct +
                '}';
    }
}
