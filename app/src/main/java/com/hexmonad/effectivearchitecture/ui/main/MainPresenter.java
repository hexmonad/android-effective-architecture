package com.hexmonad.effectivearchitecture.ui.main;

import com.hexmonad.effectivearchitecture.data.model.Items;
import com.hexmonad.effectivearchitecture.ui.base.Presenter;
import com.hexmonad.effectivearchitecture.data.api.RestApi;

import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainPresenter extends Presenter<MainView> {

    private final RestApi restApi;
    private Subscription subscription;

    public MainPresenter(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public void unbindView() {
        super.unbindView();

        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void loadItems() {
        getView().showLoadingProgress(true);

        subscription = restApi.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<Items>() {
                    @Override
                    public void onSuccess(Items items) {
                        getView().showLoadingProgress(false);
                        getView().showItems(items.getItems());
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
