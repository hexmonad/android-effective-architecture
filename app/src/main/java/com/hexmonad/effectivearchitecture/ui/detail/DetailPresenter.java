package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.model.Item;
import com.hexmonad.effectivearchitecture.ui.base.Presenter;

public class DetailPresenter extends Presenter<DetailView> {

    public DetailPresenter() {

    }

    public void loadItemDetails(Item item) {
        if (item != null) {
            getView().showItemDetails(item);
        }
    }
    
}
