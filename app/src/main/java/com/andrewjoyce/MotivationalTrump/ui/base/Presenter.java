package com.andrewjoyce.MotivationalTrump.ui.base;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public interface Presenter<T extends MvpView> {
    void attachView(T view);
    void detachView();
}
