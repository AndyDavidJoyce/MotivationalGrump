package com.andrewjoyce.MotivationalTrump;

import android.app.Application;

import com.andrewjoyce.MotivationalTrump.injection.ApplicationComponent;
import com.andrewjoyce.MotivationalTrump.injection.DaggerApplicationComponent;
import com.andrewjoyce.MotivationalTrump.injection.NetModule;

import timber.log.Timber;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public class TrumpApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }

    public ApplicationComponent getComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .netModule(new NetModule())
                    .build();
        }
        return applicationComponent;
    }

}
