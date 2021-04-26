package com.example.folder.newsaggregator

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(model:News){
        itemView.newsTitleTextView.text = model.title
        Picasso.with(itemView.context).load(model.thumbnail).into(itemView.newThumbnailImageView)
    }
}
