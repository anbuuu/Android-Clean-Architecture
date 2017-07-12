package com.anbu.switchmediaexercise.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.anbu.switchmediaexercise.R;
import com.anbu.switchmediaexercise.domain.model.CategoryItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseListAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    static final int VIEW_TYPE_CARD = 0;
    static final int VIEW_TYPE_LOADING = 20;

    final Context context;
    final List<CategoryItem> data;

    public BaseListAdapter(Context context, List<CategoryItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
    }

    @Override
    public int getItemCount() {
        if(data.size() > 0){
            return data.size() + 1;
        }

        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == data.size()){
            return VIEW_TYPE_LOADING;
        }

        return VIEW_TYPE_CARD;
    }

    public ViewHolderLoading getViewLoadingHolder(Context context, ViewGroup parent){
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_list_loading, parent, false);
        return new ViewHolderLoading(view);
    }

    public  final class ViewHolderLoading extends RecyclerView.ViewHolder {
        @BindView(R.id.progress_bar)
        ProgressBar progressBar;

        public ViewHolderLoading(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}