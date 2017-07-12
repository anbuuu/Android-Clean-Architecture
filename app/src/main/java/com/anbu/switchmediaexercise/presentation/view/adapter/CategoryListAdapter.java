package com.anbu.switchmediaexercise.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anbu.switchmediaexercise.R;
import com.anbu.switchmediaexercise.domain.model.CategoryItem;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CategoryListAdapter extends BaseListAdapter<RecyclerView.ViewHolder> {

    public CategoryListAdapter(Context context, List<CategoryItem> data) {
        super(context, data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_CARD){
            View view = LayoutInflater.from(context).inflate(R.layout.item_category_list, parent, false);
            return new ViewHolderCard(view);
        }else{
            return getViewLoadingHolder(context, parent);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolderCard){
            onBindViewHolderCard((ViewHolderCard) holder, position);
        }
    }

    private void onBindViewHolderCard(ViewHolderCard holder, int position){
        CategoryItem movie = data.get(position);

        Glide.with(context)
                .load(movie.getImages().getPortrait())
                .centerCrop()
                .into(holder.imageView);
    }

    final class ViewHolderCard extends RecyclerView.ViewHolder {
        @BindView(R.id.imageview)
        ImageView imageView;

        public ViewHolderCard(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
