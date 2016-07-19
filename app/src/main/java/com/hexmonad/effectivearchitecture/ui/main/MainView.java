package com.hexmonad.effectivearchitecture.ui.main;

import com.hexmonad.effectivearchitecture.data.model.Item;

import java.util.List;

/**
 * MainView - a View in the MVP pattern for Main page
 */
public interface MainView {

    void showLoadingProgress(boolean show);
    void showItems(List<Item> items);
    void showItemsLoadingError();

}
