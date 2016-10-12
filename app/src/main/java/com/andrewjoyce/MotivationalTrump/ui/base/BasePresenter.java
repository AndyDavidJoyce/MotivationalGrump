package com.andrewjoyce.MotivationalTrump.ui.base;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public T getMvpView() {
       return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }
}
