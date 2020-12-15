package com.manhee.newsapp_2020_mk.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.manhee.newsapp_2020_mk.R
import com.manhee.newsapp_2020_mk.repository.NewsViewModel
import com.manhee.newsapp_2020_mk.NewsActivity
import com.manhee.newsapp_2020_mk.fragments.ArticleFragment.UniqueSaver.Companion.seta
import com.manhee.newsapp_2020_mk.fragments.ArticleFragment.UniqueSaver.Companion.uniqueArticle
import kotlinx.android.synthetic.main.fragment_article.*


/** LiveData will notify the changes happening to it to this fragment.. */
class ArticleFragment : Fragment(R.layout.fragment_article) {

    class UniqueSaver {
        companion object {
            val seta = hashSetOf<String>();
            var uniqueArticle = ""
        }
    }

    // to connect this fragment with the view-model
    // in which the (view-model-provider-factory has allowed the repository in the viewModel's constructor)
    lateinit var viewModel: NewsViewModel

    // step #1: Receive the bundle sent from the 3 fragments
    // Get the argument (ie. 'ArticleFragmentArgs' is the class that
    // nav-component generated when we rebuilt the project)
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel

        // step #2: Receive the bundle sent from the 3 fragments
        // 'val article': article that was passed as an argument to this ARTICLE-FRAGMENT-transition
        val article = args.article

        uniqueArticle = article.url.toString()

        // Java-Script enabled for videos!
        webView.apply {
            webViewClient =
                WebViewClient()   // ensures that page will always inside the web-view (not in standard browser)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // chromium, enable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            } else {
                // older android version, disable hardware acceleration
                webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }

            // VIDEO in web-view
            webView.setInitialScale(1);                              // No zoom-in or zoom-out... adjust it to my browser!
            webView.settings.setJavaScriptEnabled(true);             // i) These 3 lines of code go together
            webView.settings.setLoadWithOverviewMode(true);          // ii) Fit the web to the browser
            webView.settings.setUseWideViewPort(true);

            // improve webView performance
            webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
            webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            webView.settings.setAppCacheEnabled(true)
            webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            webView.settings.domStorageEnabled = true
            webView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
            webView.settings.savePassword = true
            webView.settings.saveFormData = true
            webView.settings.enableSmoothTransition()

            // iii) View-Port
            webView.settings.setBuiltInZoomControls(true);           // i) zoomable ?
            webView.settings.setSupportZoom(true);                   // ii) finger-zomming possible
            loadUrl(article.url)

        }

        // Save-Operation Performed here! (MVVM)

        fab.setOnClickListener {

            if (!seta.contains(uniqueArticle)) {
                seta.add(uniqueArticle)
                viewModel.saveArticle(article)
                Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()

            } else {
                Toast.makeText(context, "You've already saved this article.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }
}