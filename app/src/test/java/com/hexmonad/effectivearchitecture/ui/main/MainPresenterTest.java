package com.hexmonad.effectivearchitecture.ui.main;

import com.hexmonad.effectivearchitecture.data.api.MockRestApi;
import com.hexmonad.effectivearchitecture.data.api.RestApi;
import com.hexmonad.effectivearchitecture.data.model.Items;
import com.hexmonad.effectivearchitecture.util.TestRxSchedulersHooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rx.Single;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterTest {

    private RestApi restApi;
    private MainPresenter mainPresenter;
    private MainView mainView;

    private TestRxSchedulersHooks testRxSchedulersHooks = new TestRxSchedulersHooks();

    @Before
    public void beforeEachTest() {
        testRxSchedulersHooks.registerHooks();

        restApi = mock(RestApi.class);
        mainPresenter = new MainPresenter(restApi);
        mainView = mock(MainView.class);

        mainPresenter.bindView(mainView);
    }

    @After
    public void afterEachTest() {
        testRxSchedulersHooks.unregisterHooks();
    }

    @Test
    public void loadItems_shouldSendDataToTheView() {
        Items items = new Items(MockRestApi.TEST_ITEMS);

        when(restApi.getItems()).thenReturn(Single.just(items));

        mainPresenter.loadItems();

        verify(mainView).showLoadingProgress(true);
        verify(mainView).showLoadingProgress(false);
        verify(mainView).showItems(MockRestApi.TEST_ITEMS);
        verify(mainView, never()).showItemsLoadingError();
    }
}