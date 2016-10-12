package com.andrewjoyce.MotivationalTrump.ui.quotes;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewjoyce.MotivationalTrump.databinding.ItemQuoteBinding;

import java.util.ArrayList;

/**
 * Created by andrewjoyce on 12/10/2016.
 */

public class TrumpQuotesAdapter extends RecyclerView.Adapter<TrumpQuotesAdapter.QuoteViewHolder> {

    private ArrayList<String> trumpQuotes = new ArrayList<>();

    @Override
    public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemQuoteBinding binding = DataBindingUtil.inflate(layoutInflater, com.andrewjoyce.MotivationalTrump.R.layout.item_quote, parent, false);
        return new QuoteViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(QuoteViewHolder holder, int position) {
        holder.getBinding().textQuote.setText(trumpQuotes.get(position));
    }

    @Override
    public int getItemCount() {
        return trumpQuotes.size();
    }

    public void setTrumpQuotes(ArrayList<String> trumpQuotes) {
        this.trumpQuotes.clear();
        this.trumpQuotes.addAll(trumpQuotes);
        notifyItemRangeInserted(0, this.trumpQuotes.size());
    }

    class QuoteViewHolder extends RecyclerView.ViewHolder {

        private ItemQuoteBinding binding;

        public QuoteViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ItemQuoteBinding getBinding() {
            return binding;
        }
    }
}
