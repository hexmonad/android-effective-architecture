package com.hexmonad.effectivearchitecture.ui.main;

import com.hexmonad.effectivearchitecture.data.api.MockRestApi;
import com.hexmonad.effectivearchitecture.data.api.RestApi;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    private RestApi restApi;
    private MainPresenter mainPresenter;
    private MainView mainView;

    @Before
    public void beforeEachTest() {
        restApi = MockRestApi.Factory.createRestApi();
        mainPresenter = new MainPresenter(restApi);
        mainView = mock(MainView.class);

        mainPresenter.bindView(mainView);
    }

    @Test
    public void loadItems_shouldSendDataToTheView() {
        mainPresenter.loadItems();

        verify(mainView).showLoadingProgress(true);
        verify(mainView, timeout(5000)).showLoadingProgress(false);
        verify(mainView, timeout(5000)).showItems(MockRestApi.TEST_ITEMS);
        verify(mainView, never()).showItemsLoadingError();
    }

}