package com.hexmonad.effectivearchitecture.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hexmonad.effectivearchitecture.R;
import com.hexmonad.effectivearchitecture.data.model.Item;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ItemsViewHolder
 */
public class ItemsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_item_title_text_view) TextView titleTextView;
    @BindView(R.id.list_item_image_view) ImageView imageView;

    public ItemsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Item item) {
        titleTextView.setText(item.getName());

        Glide.with(imageView.getContext())
                .load(item.getImageUrl())
                .into(imageView);
    }
}
