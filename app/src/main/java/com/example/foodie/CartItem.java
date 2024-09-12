package com.example.foodie;

import java.io.Serializable;

public class CartItem implements Serializable { // Implement Serializable
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public CartItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Optional: toString method for display purposes
    @Override
    public String toString() {
        return name + " - $" + price + " x " + quantity;
    }
}
