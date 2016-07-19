package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.api.RestApi;
import com.hexmonad.effectivearchitecture.data.model.Item;
import com.hexmonad.effectivearchitecture.data.model.ItemDetails;
import com.hexmonad.effectivearchitecture.ui.base.Presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class DetailPresenter extends Presenter<DetailView> {

    private final RestApi restApi;

    public DetailPresenter(RestApi restApi) {
        this.restApi = restApi;
    }

    public void loadItemDetails(final Item item) {
        if (item == null) {
            getView().showItemsLoadingError();
            return;
        }

        getView().showLoadingProgress(true);

        Call<ItemDetails> apiCall = restApi.getItemDetails(item.getId());

        apiCall.enqueue(new Callback<ItemDetails>() {
            @Override
            public void onResponse(Call<ItemDetails> call, Response<ItemDetails> response) {
                getView().showLoadingProgress(false);
                if (response.isSuccessful()) {
                    getView().showItemDetails(response.body());
                } else {
                    getView().showItemsLoadingError();
                }
            }

            @Override
            public void onFailure(Call<ItemDetails> call, Throwable t) {
                Timber.e(t.toString());
                getView().showLoadingProgress(false);
                getView().showItemsLoadingError();
            }
        });

    }
    
}
