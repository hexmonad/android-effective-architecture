package com.hexmonad.effectivearchitecture.ui.detail;

import com.hexmonad.effectivearchitecture.data.model.Item;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DetailPresenterTest {

    private DetailPresenter detailPresenter;
    private DetailView detailView;

    @Before
    public void beforeEachTest() {
        detailPresenter = new DetailPresenter();
        detailView = mock(DetailView.class);

        detailPresenter.bindView(detailView);
    }

    @Test
    public void loadItemDetails_shouldSendDataToTheView() {
        Item testItem = new Item("Item One");

        detailPresenter.loadItemDetails(testItem);

        verify(detailView).showItemDetails(testItem);
    }
}