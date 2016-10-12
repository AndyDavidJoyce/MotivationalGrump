package com.andrewjoyce.MotivationalTrump;

import com.andrewjoyce.MotivationalTrump.data.DataManager;
import com.andrewjoyce.MotivationalTrump.ui.quotes.TrumpQuotesPresenterImpl;
import com.andrewjoyce.MotivationalTrump.ui.quotes.TrumpQuotesView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import rx.Single;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class TrumpQuotesPresenterTest {

    @Rule public RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Mock DataManager mockDataManager;
    @Mock TrumpQuotesView mockTrumpQuotesView;

    private TrumpQuotesPresenterImpl trumpQuotesPresenter;

    @Before
    public void setUp() {
        trumpQuotesPresenter = new TrumpQuotesPresenterImpl(mockDataManager);
        trumpQuotesPresenter.attachView(mockTrumpQuotesView);
    }

    @Test
    public void testLoadTrumpQuotesReturnsSuccesfullyAndShowsQuotes() {
        ArrayList<String> trumpQuotes = new ArrayList<>();
        stubDataManagerGetQuotes(Single.just(trumpQuotes));
        trumpQuotesPresenter.loadTrumpQuotes();

        verify(mockTrumpQuotesView).showLoading(true);
        verify(mockTrumpQuotesView).showLoading(true);
        verify(mockTrumpQuotesView).showQuotes(trumpQuotes);
    }

    @Test
    public void testLoadTrumpQuotesReturnsErrorAndShowsError() {
        stubDataManagerGetQuotes(Single.error(new NullPointerException()));
        trumpQuotesPresenter.loadTrumpQuotes();

        verify(mockTrumpQuotesView, atLeast(1)).showLoading(true);
        verify(mockTrumpQuotesView, atLeast(1)).showLoading(true);
        verify(mockTrumpQuotesView).showError();
    }

    @After
    public void cleanUp() {
        trumpQuotesPresenter.detachView();
    }

    public void stubDataManagerGetQuotes(Single<ArrayList<String>> quotes) {
        when(mockDataManager.getTheBestTrumpQuotes()).thenReturn(quotes);
    }
}
