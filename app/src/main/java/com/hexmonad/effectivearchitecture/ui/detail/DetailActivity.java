/*
 * For the full copyright and license information, please view the LICENSE file that was distributed
 * with this source code. (c) 2016
 */
package com.hexmonad.effectivearchitecture.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hexmonad.effectivearchitecture.R;
import com.hexmonad.effectivearchitecture.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity implements DetailView {

    // Values for intent-related data keys must include a package prefix
    private static final String EXTRA_ITEM_DATA = "com.hexmonad.effectivearch.extras.EXTRA_ITEM_DATA";

    @BindView(R.id.detail_title_text_view) TextView titleTextView;

    public static Intent getCallingIntent(Context context, String itemData) {
        Intent callingIntent = new Intent(context, DetailActivity.class);
        callingIntent.putExtra(EXTRA_ITEM_DATA, itemData);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String itemData = getIntent().getStringExtra(EXTRA_ITEM_DATA);
        showItemDetails(itemData);
    }

    private void showItemDetails(String itemData) {
        if (itemData != null) {
            titleTextView.setText(itemData);
        }
    }
}
