package com.hexmonad.effectivearchitecture.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hexmonad.effectivearchitecture.R;
import com.hexmonad.effectivearchitecture.data.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * ItemsAdapter
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsViewHolder> {

    private List<Item> items;
    private OnItemClickListener onItemClickListener;

    public ItemsAdapter() {
        items = new ArrayList<>();
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

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Item itemData);
    }
}
