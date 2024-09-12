package com.example.foodie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // Initialize UI components
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        checkoutButton = findViewById(R.id.checkoutButton);

        // Set up RecyclerView
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        CartItemAdapter adapter = new CartItemAdapter(getCartItems(), new CartItemAdapter.OnDeleteClickListener() {
            @Override
            public void onDeleteClick(int position) {
                // Handle item delete
                deleteCartItem(position);
            }
        });
        cartRecyclerView.setAdapter(adapter);

        // Set up checkout button click listener
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle proceed to checkout
                handleCheckout();
            }
        });

        // Set up add item button click listener
        Button addItemButton = findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle add item
                addItemToCart();
            }
        });
    }

    private void handleCheckout() {
        // Implement checkout logic here
    }

    private void addItemToCart() {
        // Implement add item logic here
    }

    private List<CartItem> getCartItems() {
        // Return a list of cart items for the RecyclerView
        List<CartItem> cartItems = new ArrayList<>();
        // Add items to the list
        cartItems.add(new CartItem("Apple", 1.20, 1));
        // Add more items if needed
        return cartItems;
    }

    private void deleteCartItem(int position) {
        // Implement logic to delete item from cart
    }
}
