package com.example.foodie;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static final List<CartItem> cartItems = new ArrayList<>();

    public static void addToCart(CartItem item) {
        cartItems.add(item);
    }

    public static List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public static void clearCart() {
        cartItems.clear();
    }
}
