package pt.jnobre.padaria.model;

import java.util.List;

public class Product {

    private String description;
    private Code codeProduct;
    private List<Pack> packs;

    public Product(String description, Code codeProduct, List<Pack> packs) {
        this.description = description;
        this.codeProduct = codeProduct;
        this.packs = packs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Code getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(Code codeProduct) {
        this.codeProduct = codeProduct;
    }

    public List<Pack> getPacks() {
        return packs;
    }

    public void setPacks(List<Pack> packs) {
        this.packs = packs;
    }
}
