package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.api.MockRestApi;
import com.hexmonad.effectivearchitecture.data.api.RestApi;
import com.hexmonad.effectivearchitecture.data.model.ItemDetails;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

public class DetailPresenterTest {

    private RestApi restApi;
    private DetailPresenter detailPresenter;
    private DetailView detailView;

    @Before
    public void beforeEachTest() {
        restApi = MockRestApi.Factory.createRestApi();
        detailPresenter = new DetailPresenter(restApi);
        detailView = mock(DetailView.class);

        detailPresenter.bindView(detailView);
    }

    @Test
    public void loadItemDetails_shouldSendDataToTheView() {
        detailPresenter.loadItemDetails(MockRestApi.TEST_ITEM);

        verify(detailView).showLoadingProgress(true);
        verify(detailView, timeout(5000)).showLoadingProgress(false);
        verify(detailView, timeout(5000)).showItemDetails(MockRestApi.TEST_ITEM_DETAILS);
        verify(detailView, never()).showItemsLoadingError();
    }

    @Test
    public void loadItemDetails_shouldSendErrorToTheViewWhenItemIsNull() {
        detailPresenter.loadItemDetails(null);

        verify(detailView).showItemsLoadingError();
        verify(detailView, never()).showItemDetails(any(ItemDetails.class));
    }
}