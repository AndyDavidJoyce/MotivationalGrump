package com.andrewjoyce.MotivationalTrump.injection;

import com.andrewjoyce.MotivationalTrump.data.remote.TrumpService;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

@Module
public class NetModule {

    @Provides
    @Singleton
    public TrumpService provideTrumpApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.whatdoestrumpthink.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient())
                .build();
        return retrofit.create(TrumpService.class);
    }
}