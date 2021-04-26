package com.example.folder.newsaggregator


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showNewsFragment()
    }

    private fun showNewsFragment(){
        val tag = "NewsListFragment"
        val newsListFragment = NewsListFragment()


        val existingFragmentWithTag = supportFragmentManager.findFragmentByTag(tag)

        if(existingFragmentWithTag == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.newsListFragmentContainer, newsListFragment, tag)
                .commit()
        }
    }
}