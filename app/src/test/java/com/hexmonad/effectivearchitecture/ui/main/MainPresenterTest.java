package com.hexmonad.effectivearchitecture.ui.main;

import com.hexmonad.effectivearchitecture.data.api.RestApi;
import com.hexmonad.effectivearchitecture.data.model.Item;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainPresenterTest {

    private RestApi restApi;
    private MainPresenter mainPresenter;
    private MainView mainView;

    @Before
    public void beforeEachTest() {
        restApi = mock(RestApi.class);
        mainPresenter = new MainPresenter(restApi);
        mainView = mock(MainView.class);

        mainPresenter.bindView(mainView);
    }

    @Test
    public void loadItems_shouldSendDataToTheView() {
        List<Item> testItems = Arrays.asList(new Item("One"), new Item("Two"), new Item("Three"));

        when(restApi.getItems()).thenReturn(testItems);

        mainPresenter.loadItems();

        verify(mainView).showItems(testItems);
        //verify(mainView, never()).showItems(testItems);
    }
}