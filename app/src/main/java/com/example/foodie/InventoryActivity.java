package com.example.foodie;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InventoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private InventoryAdapter inventoryAdapter;
    private List<InventoryItem> inventoryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_activity);

        recyclerView = findViewById(R.id.inventoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        inventoryItems = new ArrayList<>();
        // Hardcoded items for demonstration
        inventoryItems.add(new InventoryItem("Apple", 1.20, 10));
        inventoryItems.add(new InventoryItem("Banana", 0.75, 20));
        inventoryItems.add(new InventoryItem("Carrot", 1.00, 15));

        inventoryAdapter = new InventoryAdapter(inventoryItems, this::onAddToCart);
        recyclerView.setAdapter(inventoryAdapter);
    }

    private void onAddToCart(InventoryItem item) {
        Toast.makeText(this, "Added to cart: " + item.getName(), Toast.LENGTH_SHORT).show();
    }
}
