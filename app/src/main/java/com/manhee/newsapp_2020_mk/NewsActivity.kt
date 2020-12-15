package com.manhee.newsapp_2020_mk

import android.app.*
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.manhee.newsapp_2020_mk.NewsActivity.ShareLinker.Companion.share_linker
import com.manhee.newsapp_2020_mk.fragments.ArticleFragment
import com.manhee.newsapp_2020_mk.repository.NewsRepository
import com.manhee.newsapp_2020_mk.repository.NewsViewModel
import com.manhee.newsapp_2020_mk.repository.NewsViewModelProviderFactory
import com.manhee.newsapp_2020_mk.ui.ArticleDatabase
import com.manhee.newsapp_2020_mk.util.toast
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_news.*
import timber.log.Timber

// This activity holds three fragments...
// (Article Fragment, BreakingNews Fragment, SearchNews Fragment)
class NewsActivity : AppCompatActivity() {

    val TAG = "News Activity... "

    // AdMob (Banner #1)
    lateinit var mAdView : AdView

    class ShareLinker {
        companion object {
            var share_linker = ""
        }
    }

    lateinit var viewModel: NewsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // Ads - init (Banner #1.5 && Interstitial #1.5)
        MobileAds.initialize(this) {}

        // banner-ads (Banner #2)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    this,
                    R.color.colorPrimary
                )
            )
        )

        actionBar!!.title = "NEWS TWICE"
        actionBar.subtitle = "Latest Breaking News"
        actionBar.elevation = 4.0F

        // instantiate 'repository'
        val newsRepository = NewsRepository(
            ArticleDatabase(
                this
            )
        )

        // instantiate 'viewModel-provider-factory' to
        // pass 'repository' as the param in the view-model constructor
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)

        // after setting up 'viewModelProviderFactory', we are finally able to
        // instantiate 'view-model'
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        // finish setting up bottom-nav-view after setting up XML (ie. bottom_navigation_menu.xml + news_nav_graph.xml)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

    }
    

    // Inflate the menu to use in the action bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Handle presses on the action bar menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.btn_share -> {

                share_linker = ArticleFragment.UniqueSaver.uniqueArticle

                Log.d(TAG, "onOptionsItemSelected-----111111: share_linker is " + share_linker)

                if (share_linker == "") {
                    toast("Please choose an article before sharing.")

                } else {

                    val shareIntent = Intent()
                    shareIntent.action = Intent.ACTION_SEND
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, share_linker)
                    startActivity(Intent.createChooser(shareIntent, "Share via"))
                    Log.d(TAG, "onOptionsItemSelected-----22222: share_linker is " + share_linker)

                }
            }


            R.id.language_select -> {
                val intent = Intent(this@NewsActivity, MainActivity::class.java)
                startActivity(intent)
            }

            R.id.save_article -> {
                Alerter.Companion.create(this)
                    .setTitle("To Save Articles")
                    .setText("Click the HEART in each article, and review in the SAVED-NEWS tab below")
                    .setIcon(R.drawable.alerter_ic_face)
                    .setBackgroundColorRes(R.color.colorPrimary)
                    .setDuration(4000)
                    .setOnClickListener(View.OnClickListener {
                        Toast.makeText(applicationContext, "Alerted", Toast.LENGTH_LONG).show()
                    })
                    .show()
            }

            R.id.delete_article -> {
                Alerter.Companion.create(this)
                    .setTitle("To Delete Articles")
                    .setText("Click an article in the SAVED-NEWS TAB below, and swipe LEFT or RIGHT.")
                    .setIcon(R.drawable.alerter_ic_face)
                    .setBackgroundColorRes(R.color.colorPrimary)
                    .setDuration(5000)
                    .setOnClickListener(View.OnClickListener {
                        Toast.makeText(applicationContext, "Alerted", Toast.LENGTH_LONG).show()
                    })
                    .show()

            }
        }

        return super.onOptionsItemSelected(item)
    }
}
