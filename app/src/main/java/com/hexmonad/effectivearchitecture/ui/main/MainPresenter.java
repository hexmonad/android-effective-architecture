package com.hexmonad.effectivearchitecture.ui.main;

import com.hexmonad.effectivearchitecture.ui.base.Presenter;
import com.hexmonad.effectivearchitecture.data.api.RestApi;

public class MainPresenter extends Presenter<MainView> {

    private final RestApi restApi;

    public MainPresenter(RestApi restApi) {
        this.restApi = restApi;
    }

    public void loadItems() {
        getView().showItems(restApi.getItems());
    }

}
