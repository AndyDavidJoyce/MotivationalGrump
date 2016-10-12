package com.andrewjoyce.MotivationalTrump.ui.quotes;

import com.andrewjoyce.MotivationalTrump.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public interface TrumpQuotesView extends MvpView {
    void showLoading(boolean loading);
    void showQuotes(ArrayList<String> quotes);
    void showError();
}
