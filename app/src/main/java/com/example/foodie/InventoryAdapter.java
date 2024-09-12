package com.example.foodie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {

    private List<InventoryItem> inventoryItems;
    private OnAddToCartClickListener onAddToCartClickListener;

    public InventoryAdapter(List<InventoryItem> inventoryItems, OnAddToCartClickListener listener) {
        this.inventoryItems = inventoryItems;
        this.onAddToCartClickListener = listener;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventory, parent, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        InventoryItem item = inventoryItems.get(position);
        holder.nameTextView.setText(item.getName());
        holder.priceTextView.setText(String.format("$%.2f", item.getPrice()));
        holder.quantityTextView.setText(String.valueOf(item.getQuantity()));

        holder.addButton.setOnClickListener(v -> onAddToCartClickListener.onAddToCart(item));
    }

    @Override
    public int getItemCount() {
        return inventoryItems.size();
    }

    public interface OnAddToCartClickListener {
        void onAddToCart(InventoryItem item);
    }

    public static class InventoryViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView priceTextView;
        TextView quantityTextView;
        Button addButton;

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            addButton = itemView.findViewById(R.id.addButton);
        }
    }
}
