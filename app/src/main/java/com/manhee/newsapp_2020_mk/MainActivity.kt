package com.manhee.newsapp_2020_mk

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.manhee.newsapp_2020_mk.MainActivity.Flagger.Companion.FLAG
import com.manhee.newsapp_2020_mk.util.logd
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    // AdMob
    // (Banner #1)
    lateinit var mAdView : AdView

    // Interstitial
    // (Interstitial #1)
    lateinit var mInterstitialAd: InterstitialAd

    class Flagger {
        companion object {
            var output : String = ""
            var FLAG : String = ""
            const val REQUEST_CODE_STT = 1
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logd("onCreate is called here... ")

        // AdMob - init
        // Banner #1.5 && Interstitial #1.5
        MobileAds.initialize(this) {}

        // ★★★ Banner #2
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // ★★★ interstitial #2
        // (real-Ad-Id : ca-app-pub-4638865955969792/1829527818)
        // (tester-Ad-id: ca-app-pub-3940256099942544/1033173712)
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())


        // Get the support action bar
        // && Set the action bar title, subtitle and elevation
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

        // 1 - America - us
        // 2 - Australia - AU
        // 3 - brazil - BR
        // 4 - canada - CA
        // 5 - france - FR
        // 6 - germany - DE
        // 7 - great britain - GB
        // 8 - india - IN
        // 9 - israel - IL
        // 10 - italy - IT
        // 11 - japan - JP
        // 12 - korea - KR
        // 13 - russia - ru
        // 14 - South Africa - za
        // 15 - turkey - TR


        // 1 - America - us
        img_america.setOnClickListener {
            FLAG = "us"
            moveToNextActivity()
        }

        // 2 - Australia - AU
        img_australia.setOnClickListener {
            FLAG = "au"
            moveToNextActivity()
        }

        // 3 - brazil - BR
        img_brazil.setOnClickListener {
            FLAG = "br"
            moveToNextActivity()
        }

        // 4 - canada - CA
        img_canada.setOnClickListener {
            FLAG = "ca"
            moveToNextActivity()
        }

        // 5 - france - FR
        img_france.setOnClickListener {
            FLAG = "fr"
            moveToNextActivity()
        }

        // 6 - germany - DE
        img_germany.setOnClickListener {
            FLAG = "de"
            moveToNextActivity()
        }

        // 7 - greatbritain - GB
        img_greatbritain.setOnClickListener {
            FLAG = "gb"
            moveToNextActivity()
        }

        // 8 - india - IN
        img_india.setOnClickListener {
            FLAG = "in"
            moveToNextActivity()
        }

        // 9 - israel - IL
        img_israel.setOnClickListener {
            FLAG = "il"
            moveToNextActivity()
        }

        // 10 - italy - IT
        img_italy.setOnClickListener {
            FLAG = "it"
            moveToNextActivity()
        }

        // 11 - japan - JP
        img_japan.setOnClickListener {
            FLAG = "jp"
            moveToNextActivity()
        }

        // 12 - korea - KR
        img_korea.setOnClickListener {
            FLAG = "kr"
            moveToNextActivity()
        }

        // 13 - russia - ru
        img_russia.setOnClickListener {
            FLAG = "ru"
            moveToNextActivity()
        }

        // 14 - South Africa - za
        img_southafrica.setOnClickListener {
            FLAG = "za"
            moveToNextActivity()
        }

        // 15 - sweden - SE
        img_sweden.setOnClickListener {
            FLAG = "se"
            moveToNextActivity()
        }
    }

    fun moveToNextActivity() {
        val intent = Intent(this@MainActivity, NewsActivity::class.java)
        startActivity(intent)
    }

    // ★★★ interstitial
    // (Interstitial #3)
    override fun onBackPressed() {
        super.onBackPressed()

        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
            Timber.d("onBackPressed: interstitial ad was loaded... ")

        } else {
            Timber.d("onBackPressed: interstitial ad was not loaded yet... ")
        }
    }

}
