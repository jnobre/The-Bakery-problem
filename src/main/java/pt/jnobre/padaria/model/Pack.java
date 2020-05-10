package pt.jnobre.padaria.model;

public class Pack {

    private int quantity;
    private float price;
    private Code codeProduct;

    public Pack(int quantity, float price, Code codeProduct) {
        this.quantity = quantity;
        this.price = price;
        this.codeProduct = codeProduct;
    }

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
}
