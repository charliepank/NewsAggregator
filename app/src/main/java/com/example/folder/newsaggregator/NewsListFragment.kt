package com.example.folder.newsaggregator


import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase as fbd
import com.google.firebase.database.Query as fbQuery
import com.mobymagic.easyfirebaselist.EmptyStyle
import com.mobymagic.easyfirebaselist.ErrorStyle
import com.mobymagic.easyfirebaselist.ProgressStyle
import com.thefinestartist.finestwebview.FinestWebView
import com.mobymagic.easyfirebaselist.database.FirebaseDbListFragment as FirebaseDbListFragment1


class NewsListFragment  : FirebaseDbListFragment1<News, NewsViewHolder>(){
    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }*/

    override fun getDataClass(): Class<News> {
        return News::class.java
    }
    //@JvmName("myfunctionWithFoo")

    override fun getEmptyStyle(): EmptyStyle {
        return EmptyStyle(R.drawable.ic_error_view_cloud,"No news yet in database")
    }

    override fun getErrorStyle(error: DatabaseError): ErrorStyle {
        return ErrorStyle(R.drawable.ic_error_view_cloud,"An error occurred while fetching news")
    }


    override fun getProgressStyle(): ProgressStyle {
        return ProgressStyle("Loading...")
    }

    override fun getQuery(): fbQuery {
        return com.google.firebase.database.FirebaseDatabase.getInstance().reference.child("news").limitToLast(100)
    }

    override fun onBindViewHolder(viewHolder: NewsViewHolder, key: String, model: News) {
        viewHolder.bind(model)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup): NewsViewHolder {
        val view = inflater.inflate(R.layout.item_news, viewGroup, false)
        return NewsViewHolder(inflater.inflate(R.layout.item_news, viewGroup, false))
    }

    override fun onItemClicked(viewHolder: NewsViewHolder,key: String, model: News) {
        FinestWebView.Builder(Activity()).show(model.link)
    }

    override fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }

}