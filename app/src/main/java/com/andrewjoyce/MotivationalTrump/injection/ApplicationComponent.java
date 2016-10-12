package com.andrewjoyce.MotivationalTrump.injection;

import com.andrewjoyce.MotivationalTrump.ui.quotes.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

@Singleton
@Component(modules = {NetModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
