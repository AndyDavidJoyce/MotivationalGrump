package com.andrewjoyce.MotivationalTrump.data;

import com.andrewjoyce.MotivationalTrump.data.remote.TrumpService;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Single;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public class DataManager {

    private TrumpService trumpService;

    @Inject
    public DataManager(TrumpService trumpService) {
        this.trumpService = trumpService;
    }

    public Single<ArrayList<String>> getTheBestTrumpQuotes() {
        return trumpService.getTrumpQuotes().map(trumpResponse -> trumpResponse.messages.personalized);
    }
}
