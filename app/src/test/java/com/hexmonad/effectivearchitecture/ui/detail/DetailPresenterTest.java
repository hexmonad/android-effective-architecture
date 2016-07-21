package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.api.MockRestApi;
import com.hexmonad.effectivearchitecture.data.api.RestApi;
import com.hexmonad.effectivearchitecture.data.model.Item;
import com.hexmonad.effectivearchitecture.data.model.ItemDetails;
import com.hexmonad.effectivearchitecture.util.TestRxSchedulersHooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rx.Single;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailPresenterTest {

    private RestApi restApi;
    private DetailPresenter detailPresenter;
    private DetailView detailView;

    private TestRxSchedulersHooks testRxSchedulersHooks = new TestRxSchedulersHooks();

    @Before
    public void beforeEachTest() {
        testRxSchedulersHooks.registerHooks();

        restApi = mock(RestApi.class);
        detailPresenter = new DetailPresenter(restApi);
        detailView = mock(DetailView.class);

        detailPresenter.bindView(detailView);
    }

    @After
    public void afterEachTest() {
        testRxSchedulersHooks.unregisterHooks();
    }

    @Test
    public void loadItemDetails_shouldSendDataToTheView() {
        Item item = MockRestApi.TEST_ITEM;
        ItemDetails itemDetails = MockRestApi.TEST_ITEM_DETAILS;

        when(restApi.getItemDetails(item.getId())).thenReturn(Single.just(itemDetails));

        detailPresenter.loadItemDetails(item);

        verify(detailView).showLoadingProgress(true);
        verify(detailView).showLoadingProgress(false);
        verify(detailView).showItemDetails(itemDetails);
        verify(detailView, never()).showItemsLoadingError();
    }

    @Test
    public void loadItemDetails_shouldSendErrorToTheViewWhenItemIsNull() {
        detailPresenter.loadItemDetails(null);

        verify(detailView).showItemsLoadingError();
        verify(detailView, never()).showItemDetails(any(ItemDetails.class));
    }
}