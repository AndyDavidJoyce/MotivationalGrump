package com.andrewjoyce.MotivationalTrump.ui.quotes;

import com.andrewjoyce.MotivationalTrump.data.DataManager;
import com.andrewjoyce.MotivationalTrump.ui.base.BasePresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public class TrumpQuotesPresenterImpl extends BasePresenter<TrumpQuotesView> {

    private DataManager dataManager;

    @Inject
    public TrumpQuotesPresenterImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void loadTrumpQuotes() {
        getMvpView().showLoading(true);
        dataManager.getTheBestTrumpQuotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ArrayList<String>>() {
                    @Override
                    public void onSuccess(ArrayList<String> value) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                            getMvpView().showQuotes(value);
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        if (isViewAttached()) {
                            getMvpView().showLoading(false);
                            getMvpView().showError();
                        }
                    }
                });
    }
}
