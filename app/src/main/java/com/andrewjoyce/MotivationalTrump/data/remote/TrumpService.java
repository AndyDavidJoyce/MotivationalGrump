package com.andrewjoyce.MotivationalTrump.data.remote;

import com.andrewjoyce.MotivationalTrump.data.model.TrumpResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public interface TrumpService {

    @GET("quotes")
    Single<TrumpResponse> getTrumpQuotes();

    @GET("quotes/random")
    Single<String> getRandomTrumpQuote();

    @GET("quotes/personalized")
    Single<String> getPersonalizedTrumpQuote(@Query("q") String name);
}
