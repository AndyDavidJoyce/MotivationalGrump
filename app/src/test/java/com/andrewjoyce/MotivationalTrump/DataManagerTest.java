package com.andrewjoyce.MotivationalTrump;

import com.andrewjoyce.MotivationalTrump.data.DataManager;
import com.andrewjoyce.MotivationalTrump.data.model.Message;
import com.andrewjoyce.MotivationalTrump.data.model.TrumpResponse;
import com.andrewjoyce.MotivationalTrump.data.remote.TrumpService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import rx.Single;
import rx.observers.TestSubscriber;

import static org.mockito.Mockito.when;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Rule
    public RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Mock TrumpService mockTrumpService;

    private DataManager dataManager;

    @Before
    public void setUp() {
        dataManager = new DataManager(mockTrumpService);
    }

    @Test
    public void testGetTrumpQuotesCompletesSuccesfully() {
        Message message = new Message();
        message.personalized = new ArrayList<>();

        TrumpResponse trumpResponse = new TrumpResponse();
        trumpResponse.messages = message;

        stubTrumpServiceGetTrumpQuotes(Single.just(trumpResponse));

        TestSubscriber<ArrayList<String>> testSubscriber = new TestSubscriber<>();
        dataManager.getTheBestTrumpQuotes().subscribe(testSubscriber);
        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();
    }
    
    public void stubTrumpServiceGetTrumpQuotes(Single<TrumpResponse> trumpResponse) {
        when(mockTrumpService.getTrumpQuotes()).thenReturn(trumpResponse);
    }


}
