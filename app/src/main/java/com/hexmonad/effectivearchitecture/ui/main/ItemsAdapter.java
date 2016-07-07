package com.hexmonad.effectivearchitecture.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hexmonad.effectivearchitecture.R;

import java.util.Arrays;
import java.util.List;

/**
 * ItemsAdapter
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsViewHolder> {

    private List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
    private OnItemClickListener onItemClickListener;

    public ItemsAdapter() {

    }

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);
        final ItemsViewHolder itemsViewHolder = new ItemsViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = itemsViewHolder.getAdapterPosition();
                onItemClickListener.onItemClick(items.get(itemPosition));
            }
        });

        return itemsViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(String itemData);
    }
}
