package com.anbu.switchmediaexercise.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.anbu.switchmediaexercise.R
import com.anbu.switchmediaexercise.domain.model.CategoryItem
import com.bumptech.glide.Glide

import butterknife.BindView
import butterknife.ButterKnife


class CategoryListAdapter(context: Context, data: List<CategoryItem>) : BaseListAdapter<RecyclerView.ViewHolder>(context, data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == BaseListAdapter.VIEW_TYPE_CARD) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_category_list, parent, false)
            return ViewHolderCard(view)
        } else {
            return getViewLoadingHolder(context, parent)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderCard) {
            onBindViewHolderCard(holder, position)
        }
    }

    private fun onBindViewHolderCard(holder: ViewHolderCard, position: Int) {
        val movie = data[position]

        Glide.with(context)
                .load(movie.images.portrait)
                .centerCrop()
                .into(holder.imageView!!)
    }

    internal inner class ViewHolderCard(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.imageview)
        var imageView: ImageView? = null

        init {
            ButterKnife.bind(this, itemView)
        }
    }

}
