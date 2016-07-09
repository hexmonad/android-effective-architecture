package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.ui.base.Presenter;

public class DetailPresenter extends Presenter<DetailView> {

    public DetailPresenter() {

    }

    public void loadItemDetails(String item) {
        getView().showItemDetails(item);
    }
    
}
