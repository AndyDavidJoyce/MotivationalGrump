package com.andrewjoyce.MotivationalTrump.ui.quotes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.andrewjoyce.MotivationalTrump.TrumpApplication;
import com.andrewjoyce.MotivationalTrump.databinding.ActivityMainBinding;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements TrumpQuotesView{

    @Inject TrumpQuotesPresenterImpl quotesPresenter;

    private TrumpQuotesAdapter trumpQuotesAdapter;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, com.andrewjoyce.MotivationalTrump.R.layout.activity_main);
        ((TrumpApplication)getApplication()).getComponent().inject(this);
        init();
    }

    public void init() {
        setUpPresenter();
        setUpRecyclerView();
    }

    public void setUpPresenter() {
        quotesPresenter.attachView(this);
        quotesPresenter.loadTrumpQuotes();
    }

    public void setUpRecyclerView() {
        binding.recyclerRepositories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerRepositories.setAdapter(getAdapter());
    }

    public TrumpQuotesAdapter getAdapter() {
        if (trumpQuotesAdapter == null) {
            trumpQuotesAdapter = new TrumpQuotesAdapter();
        }
        return trumpQuotesAdapter;
    }

    @Override
    public void showLoading(boolean loading) {
        binding.progressRepositories.setVisibility(loading ? View.VISIBLE : View.INVISIBLE);
        binding.recyclerRepositories.setVisibility(loading ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public void showError() {}

    @Override
    public void showQuotes(ArrayList<String> quotes) {
        trumpQuotesAdapter.setTrumpQuotes(quotes);
    }
}
