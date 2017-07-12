package com.anbu.switchmediaexercise.presentation.view.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anbu.switchmediaexercise.R;
import com.anbu.switchmediaexercise.domain.model.CategoryItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fragment which shows a particular Item detail
 */

public class AcmeCategoryItemDetailFragment extends Fragment  {

    @BindView(R.id.itemDetailImage)
    ImageView itemDetailImage;

    @BindView(R.id.itemDetailTitle)
    TextView itemDetailTitle;

    @BindView(R.id.itemDetailYear)
    TextView itemDetailYear;

    @BindView(R.id.item_detail_description)
    TextView itemDetailDescription;

    private CategoryItem dataholder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        // Get the Bundle Details
         dataholder = (CategoryItem)getArguments().getSerializable("itemData");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_item_details, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemDetailTitle.setText(dataholder.getTitle());

        String imageURL = dataholder.getImages().getPortrait();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            if ( dataholder.getImages().getLandscape() != null &&
                    dataholder.getImages().getLandscape().length() > 0 )  {
                imageURL = dataholder.getImages().getLandscape();
            }

        }

        Picasso.with(getContext())
                .load(imageURL)
                .fit()
                .error(R.drawable.android)
                .into(itemDetailImage);

        itemDetailYear.setText(String.valueOf(dataholder.getYear()));
        itemDetailDescription.setText(dataholder.getDescription());
    }

}
