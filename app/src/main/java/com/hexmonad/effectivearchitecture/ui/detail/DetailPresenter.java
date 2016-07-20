package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.api.RestApi;
import com.hexmonad.effectivearchitecture.data.model.Item;
import com.hexmonad.effectivearchitecture.data.model.ItemDetails;
import com.hexmonad.effectivearchitecture.ui.base.Presenter;

import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class DetailPresenter extends Presenter<DetailView> {

    private final RestApi restApi;
    private Subscription subscription;

    public DetailPresenter(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void unbindView() {
        super.unbindView();

        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void loadItemDetails(final Item item) {
        if (item == null) {
            getView().showItemsLoadingError();
            return;
        }

        getView().showLoadingProgress(true);

        subscription = restApi.getItemDetails(item.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ItemDetails>() {
                    @Override
                    public void onSuccess(ItemDetails itemDetails) {
                        getView().showLoadingProgress(false);
                        getView().showItemDetails(itemDetails);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Timber.e(error.toString());
                        getView().showLoadingProgress(false);
                        getView().showItemsLoadingError();
                    }
                });
    }

}
