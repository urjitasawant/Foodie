package com.example.foodie;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private List<InventoryItem> inventoryItems;
    private List<CartItem> cartItems; // List to store cart items
    private RecyclerView inventoryRecyclerView;
    private Button viewCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewCartButton = findViewById(R.id.viewCartButton);
        inventoryRecyclerView = findViewById(R.id.inventoryRecyclerView);

        // Initialize the cartItems list
        cartItems = new ArrayList<>();

        // Sample inventory items
        inventoryItems = new ArrayList<>();
        inventoryItems.add(new InventoryItem("Apple", 1.20, 100));
        inventoryItems.add(new InventoryItem("Banana", 0.50, 150));
        inventoryItems.add(new InventoryItem("Carrot", 0.30, 200));
        inventoryItems.add(new InventoryItem("Chicken Breast", 5.00, 50));
        inventoryItems.add(new InventoryItem("Wheat Bread", 2.00, 100));

        // Set up the UI with inventory items
        setupInventory();

        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            // Pass cart items to CartActivity using Intent
            intent.putExtra("cartItems", new ArrayList<>(cartItems));
            startActivity(intent);
        });
    }

    private void setupInventory() {
        // Initialize RecyclerView
        inventoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create and set adapter
        InventoryAdapter adapter = new InventoryAdapter(inventoryItems, this::onAddToCart);
        inventoryRecyclerView.setAdapter(adapter);
    }

    private void onAddToCart(InventoryItem item) {
        // Check if item is already in the cart
        for (CartItem cartItem : cartItems) {
            if (cartItem.getName().equals(item.getName())) {
                // Increment the quantity if the item is already in the cart
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                Toast.makeText(this, item.getName() + " quantity updated in cart", Toast.LENGTH_SHORT).show();
                return;
            }
        }



        // Add new item to cart
        cartItems.add(new CartItem(item.getName(), item.getPrice(), 1));
        Toast.makeText(this, item.getName() + " added to cart", Toast.LENGTH_SHORT).show();

        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            // Correctly pass cart items using Serializable
            intent.putExtra("cartItems", new ArrayList<>(cartItems));
            startActivity(intent);
        });

    }
}
