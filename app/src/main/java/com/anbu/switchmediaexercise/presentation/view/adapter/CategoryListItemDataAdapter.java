package com.anbu.switchmediaexercise.presentation.view.adapter;


import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anbu.switchmediaexercise.AcmeApplication;
import com.anbu.switchmediaexercise.R;
import com.anbu.switchmediaexercise.domain.model.CategoryItem;
import com.anbu.switchmediaexercise.presentation.events.EventFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter that manages a item of {@link CategoryItem}
 */

public class CategoryListItemDataAdapter extends RecyclerView.Adapter<CategoryListItemDataAdapter.CategorySingleItemRowHolder> {

    private List<CategoryItem> categoryItemList;
    private Context mContext;
    private String categoryName;

    public CategoryListItemDataAdapter(Context context, List<CategoryItem> categoryItemList, String categoryName) {
        this.categoryItemList = categoryItemList;
        this.mContext = context;
        this.categoryName = categoryName;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public CategorySingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //TODO verify this
        CategorySingleItemRowHolder categorySingleItemRowHolder;
        if ( categoryName.equalsIgnoreCase(mContext.getResources().getString(R.string.FEATURES)) ) {
            // Create view holder with big layout
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list_single_big_card, null);
            categorySingleItemRowHolder = new CategorySingleItemRowHolder(v);
        } else {
            // create normal layout
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_list_single_card, null);
            categorySingleItemRowHolder = new CategorySingleItemRowHolder(v);
        }
        return categorySingleItemRowHolder;
    }

    @Override
    public void onBindViewHolder(CategorySingleItemRowHolder holder, int i) {

        final CategoryItem singleItem = categoryItemList.get(i);
        holder.tvTitle.setText(singleItem.getTitle());

        String imageURL = singleItem.getImages().getPortrait();
        if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            if ( singleItem.getImages().getLandscape() != null &&
                    singleItem.getImages().getLandscape().length() > 0 )  {
                imageURL = singleItem.getImages().getLandscape();
            }
        }

        Picasso.with(mContext)
                .load(imageURL)
                .fit()
                .into(holder.itemImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AcmeApplication.get().bus().post(new EventFragment(singleItem));
            }
        });
    }


    @Override
    public int getItemCount() {
        return (null != categoryItemList ? categoryItemList.size() : 0);
    }

    public class CategorySingleItemRowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.itemImage)
        ImageView itemImage;

        public CategorySingleItemRowHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
           }
    }

    
}