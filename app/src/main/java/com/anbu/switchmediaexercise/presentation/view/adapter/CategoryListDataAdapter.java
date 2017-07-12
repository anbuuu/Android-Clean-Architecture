package com.anbu.switchmediaexercise.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anbu.switchmediaexercise.R;
import com.anbu.switchmediaexercise.domain.model.CategoryItem;
import com.anbu.switchmediaexercise.domain.model.CategoryList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter that manages a Collection of {@link com.anbu.switchmediaexercise.domain.model.CategoryList}
 */

public class CategoryListDataAdapter extends RecyclerView.Adapter<CategoryListDataAdapter.CategoryListItemRowHolder> {

    private ArrayList<CategoryList> dataList;
    private Context mContext;

    public CategoryListDataAdapter(Context context, ArrayList<CategoryList> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public CategoryListItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
        return new CategoryListItemRowHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public void onBindViewHolder(CategoryListItemRowHolder categoryListItemRowHolder, int i) {

        final String sectionName = dataList.get(i).getCategory();
        List<CategoryItem> singleSectionItems =  dataList.get(i).getItems();
        categoryListItemRowHolder.itemTitle.setText(sectionName);
        CategoryListItemDataAdapter itemListDataAdapter = new CategoryListItemDataAdapter(mContext, singleSectionItems, sectionName);

        categoryListItemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        categoryListItemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);
        categoryListItemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);
        categoryListItemRowHolder.recycler_view_list.setSaveEnabled(true);

        categoryListItemRowHolder.recycler_view_list.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        //Allow ScrollView to intercept touch events once again.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle RecyclerView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class CategoryListItemRowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.categoryHeader)
        TextView itemTitle;

        @BindView(R.id.recycler_view_list)
        RecyclerView recycler_view_list;

        public CategoryListItemRowHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}