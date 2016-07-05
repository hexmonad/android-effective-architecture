package com.hexmonad.effectivearchitecture.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hexmonad.effectivearchitecture.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ItemsViewHolder
 */
public class ItemsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_item_title_text_view) TextView titleTextView;

    public ItemsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String item) {
        titleTextView.setText(item);
    }
}
