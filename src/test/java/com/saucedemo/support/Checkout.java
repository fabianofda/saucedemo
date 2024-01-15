package com.saucedemo.support;

public class Checkout {

    private String qty;
    private String description;
    private String price;
   

    public Checkout(String qty, String description, String price) {

        this.qty = qty;
        this.description = description;
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
