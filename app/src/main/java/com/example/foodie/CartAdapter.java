package com.example.foodie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartItem> cartItems;
    private OnDeleteClickListener onDeleteClickListener;

    public CartAdapter(List<CartItem> cartItems, OnDeleteClickListener onDeleteClickListener) {
        this.cartItems = cartItems;
        this.onDeleteClickListener = onDeleteClickListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText(String.format("$%.2f", item.getPrice()));
        holder.deleteButton.setOnClickListener(v -> onDeleteClickListener.onDeleteClick(item));
        // You can set an image here if you have one
        // holder.itemImage.setImageResource(R.drawable.your_image);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public interface OnDeleteClickListener {
        void onDeleteClick(CartItem item);
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemPrice;
        Button deleteButton;
        ImageView itemImage;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
