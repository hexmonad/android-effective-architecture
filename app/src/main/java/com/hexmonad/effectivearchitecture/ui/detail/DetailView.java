package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.model.ItemDetails;

/**
 * DetailView - a View in the MVP pattern for Detail page
 */
public interface DetailView {

    void showLoadingProgress(boolean show);
    void showItemDetails(ItemDetails itemDetails);
    void showItemsLoadingError();

}
