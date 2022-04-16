package com.example.myapplication;

public class ProductData {
    private String ID;
    private String Name;
    int inStock;

    public  ProductData() {}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public ProductData(String Id, String Name, int s) {
        this.ID = Id;
        this.Name = Name;
        this.inStock = s;
    }
}

