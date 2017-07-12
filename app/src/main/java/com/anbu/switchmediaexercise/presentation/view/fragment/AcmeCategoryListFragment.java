package com.anbu.switchmediaexercise.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anbu.switchmediaexercise.AcmeApplication;
import com.anbu.switchmediaexercise.R;
import com.anbu.switchmediaexercise.domain.model.CategoryList;
import com.anbu.switchmediaexercise.presentation.presenter.AcmePresenter;
import com.anbu.switchmediaexercise.presentation.view.AcmeResultsView;
import com.anbu.switchmediaexercise.presentation.view.adapter.CategoryListDataAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Fragment that shows a list of Categories
 */

public class AcmeCategoryListFragment extends Fragment
        implements AcmeResultsView,
        SwipeRefreshLayout.OnRefreshListener
        {

    private Context context;

    @Inject
    AcmePresenter presenter;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ArrayList<CategoryList> categoryList;

    private CategoryListDataAdapter categoryListDataAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        AcmeApplication.component().inject(this);

        context = getContext();
        categoryList = new ArrayList<>();

        // Horizontal
        categoryListDataAdapter = new CategoryListDataAdapter(getContext(), categoryList);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return getView() != null ? getView() : inflater.inflate
                (R.layout.fragment_category_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        refreshLayout.setOnRefreshListener(this);
        recyclerView.setAdapter(categoryListDataAdapter);
        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setSaveEnabled(true);

        presenter.bind(this);
        if ( savedInstanceState == null ) {
            presenter.loadCategoryList();
        }
    }

    /**
     * {@link com.anbu.switchmediaexercise.presentation.view.shared.LoadingView}
     */
    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onCategoryListLoaded(ArrayList<CategoryList> list) {
       Collections.sort(list, new Comparator<CategoryList>() {
            @Override
            public int compare(CategoryList o1, CategoryList o2) {
                return o1.getCategory().compareToIgnoreCase(o2.getCategory());
            }
        });

        categoryList.clear();
        categoryList.addAll(list);
        categoryListDataAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCategoryListLoadError() {
        Toast.makeText(getContext(), getResources().getString(R.string.defaultErrorMsg),
                Toast.LENGTH_LONG ).show();
    }

    @Override
    public void onRefresh() {
        presenter.loadCategoryList();
    }

}
