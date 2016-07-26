/*
 * For the full copyright and license information, please view the LICENSE file that was distributed
 * with this source code. (c) 2016
 */
package com.hexmonad.effectivearchitecture.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hexmonad.effectivearchitecture.R;
import com.hexmonad.effectivearchitecture.data.model.Item;
import com.hexmonad.effectivearchitecture.ui.base.BaseActivity;
import com.hexmonad.effectivearchitecture.ui.base.Navigator;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.main_recycler_view) RecyclerView recyclerView;
    @BindView(R.id.main_progress_bar) View progressBar;
    @BindView(R.id.main_layout_retry) View retryLayout;
    @BindView(R.id.main_button_retry) View retryButton;

    @Inject MainPresenter mainPresenter;
    private ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        itemsAdapter = new ItemsAdapter();
        itemsAdapter.setOnItemClickListener(new ItemsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item itemData) {
                Navigator.navigateToDetailPage(MainActivity.this, itemData);
            }
        });

        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter.bindView(this);
        mainPresenter.loadItems();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mainPresenter.unbindView();
    }

    @Override
    public void showLoadingProgress(boolean show) {
        retryLayout.setVisibility(View.GONE);
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showItems(List<Item> items) {
        itemsAdapter.setItems(items);
        itemsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showItemsLoadingError() {
        retryLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.main_button_retry)
    public void retry() {
        mainPresenter.loadItems();
    }
}
