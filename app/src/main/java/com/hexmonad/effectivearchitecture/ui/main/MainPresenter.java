package com.hexmonad.effectivearchitecture.ui.main;

import com.hexmonad.effectivearchitecture.data.model.Items;
import com.hexmonad.effectivearchitecture.ui.base.Presenter;
import com.hexmonad.effectivearchitecture.data.api.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainPresenter extends Presenter<MainView> {

    private final RestApi restApi;

    public MainPresenter(RestApi restApi) {
        this.restApi = restApi;
    }

    public void loadItems() {
        getView().showLoadingProgress(true);

        Call<Items> apiCall = restApi.getItems();

        apiCall.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                getView().showLoadingProgress(false);
                if (response.isSuccessful()) {
                    getView().showItems(response.body().getItems());
                } else {
                    getView().showItemsLoadingError();
                }
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Timber.e(t.toString());
                getView().showLoadingProgress(false);
                getView().showItemsLoadingError();
            }
        });

    }

}
