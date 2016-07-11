package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.model.Item;

/**
 * DetailView - a View in the MVP pattern for Detail page
 */
public interface DetailView {

    void showItemDetails(Item item);

}
