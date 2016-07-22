/*
 * For the full copyright and license information, please view the LICENSE file that was distributed
 * with this source code. (c) 2016
 */
package com.hexmonad.effectivearchitecture.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hexmonad.effectivearchitecture.R;
import com.hexmonad.effectivearchitecture.data.model.Item;
import com.hexmonad.effectivearchitecture.data.model.ItemDetails;
import com.hexmonad.effectivearchitecture.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailView {

    // Values for intent-related data keys must include a package prefix
    private static final String EXTRA_ITEM_DATA = "com.hexmonad.effectivearch.extras.EXTRA_ITEM_DATA";

    @BindView(R.id.detail_title_text_view) TextView titleTextView;
    @BindView(R.id.detail_height_text_view) TextView heightTextView;
    @BindView(R.id.detail_weight_text_view) TextView weightTextView;
    @BindView(R.id.detail_type_text_view) TextView typeTextView;
    @BindView(R.id.detail_front_image_view) ImageView frontImageView;
    @BindView(R.id.detail_back_image_view) ImageView backImageView;
    @BindView(R.id.detail_progress_bar) View progressBar;
    @BindView(R.id.detail_info_layout) View infoLayout;

    @Inject DetailPresenter detailPresenter;

    public static Intent getCallingIntent(Context context, Item item) {
        Intent callingIntent = new Intent(context, DetailActivity.class);
        callingIntent.putExtra(EXTRA_ITEM_DATA, item);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        detailPresenter.bindView(this);

        Item item = getIntent().getParcelableExtra(EXTRA_ITEM_DATA);
        detailPresenter.loadItemDetails(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        detailPresenter.unbindView();
    }

    @Override
    public void showLoadingProgress(boolean show) {
        infoLayout.setVisibility(show ? View.INVISIBLE : View.VISIBLE);
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showItemDetails(ItemDetails itemDetails) {
        titleTextView.setText(itemDetails.getName());
        heightTextView.setText(String.valueOf(itemDetails.getHeight()));
        weightTextView.setText(String.valueOf(itemDetails.getWeight()));
        typeTextView.setText(itemDetails.getType());

        Glide.with(this)
                .load(itemDetails.getSprites().getFrontImageUrl())
                .into(frontImageView);

        Glide.with(this)
                .load(itemDetails.getSprites().getBackImageUrl())
                .into(backImageView);
    }

    @Override
    public void showItemsLoadingError() {
        Toast.makeText(this, R.string.detail_error_item_loading, Toast.LENGTH_SHORT).show();
    }
}
