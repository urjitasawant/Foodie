package com.example.foodie;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private ArrayAdapter<CartItem> cartAdapter;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        checkoutButton = findViewById(R.id.checkoutButton);

        // Retrieve the cart items passed from HomeActivity
        List<CartItem> cartItems = (List<CartItem>) getIntent().getSerializableExtra("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>(); // Handle the case where cart items are null
        }

        cartAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(cartAdapter);

        checkoutButton.setOnClickListener(v -> {
            // Handle checkout button click
            Toast.makeText(CartActivity.this, "Proceeding to checkout", Toast.LENGTH_SHORT).show();
            // Navigate to CheckoutActivity
            startActivity(new Intent(CartActivity.this, CheckoutActivity.class));
        });
    }
}
