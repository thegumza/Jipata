package com.jipata.thegumza.jipata.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jipata.thegumza.jipata.R;

import java.util.List;

/**
 * Created by Thegumza on 8/15/2016.
 */
public class RubberPriceAdapter extends RecyclerView.Adapter {

    Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewHolder;
        viewHolder = inflater.inflate(R.layout.price_item, parent, false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView provinceText;
        private TextView priceText;
        private TextView volumeText;

        public ViewHolder(View itemView) {
            super(itemView);
            this.provinceText = (TextView) itemView.findViewById(R.id.provinceText);
            this.priceText = (TextView) itemView.findViewById(R.id.priceText);
            this.volumeText = (TextView) itemView.findViewById(R.id.volumeText);
        }
    }
}
