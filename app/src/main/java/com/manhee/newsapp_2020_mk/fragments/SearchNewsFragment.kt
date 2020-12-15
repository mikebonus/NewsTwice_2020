package com.manhee.newsapp_2020_mk.fragments

import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.Html
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.mvvmnewsapp.api.NewsAdapter
import com.manhee.newsapp_2020_mk.MainActivity
import com.manhee.newsapp_2020_mk.R
import com.manhee.newsapp_2020_mk.repository.NewsViewModel
import com.manhee.newsapp_2020_mk.ui.Constants
import com.manhee.newsapp_2020_mk.ui.Constants.Companion.SEARCH_NEWS_TIME_DELAY
import com.manhee.newsapp_2020_mk.NewsActivity
import com.manhee.newsapp_2020_mk.ui.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import kotlinx.android.synthetic.main.fragment_breaking_news.paginationProgressBar
import kotlinx.android.synthetic.main.fragment_search_news.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

/** LiveData will notify the changes happening to it to this fragment */
class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    // to connect this fragment with the view-model
    // in which the (view-model-provider-factory has allowed the repository in the viewModel's constructor)
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        // do this before fragment-transition (ie. target destination is 'Article-Fragment')
        // (ie. This 'article' comes from the fact that 'Article' in <Model> is 'serializable')
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)      // it ---> remember that we ADDED ARGUMENTS in navigation-graph-settings
            }

            // Target is 'Article-Fragment'
            // (ie. add bundle to nav-component && send all the bundles to 'Article-Fragment')
            // (This is done through navigation-component-library)

            findNavController().navigate(
                R.id.action_searchNewsFragment_to_articleFragment, bundle
            )

        }

        /** THIS COROUTINE is only present in 'SearchNewsFragment.kt' (ie. NOT in BreakingNewsFragment.kt || SavedNewsFragment.kt) */
        // let us make some delay for every word that we type for request...
        // otherwise, it would cause too many requests...
        var job: Job? = null        // Coroutine's 'Job' ideal for delay-requesting...

        etSearch.addTextChangedListener { editable ->
            job?.cancel()

            job = MainScope().launch {
                delay(SEARCH_NEWS_TIME_DELAY)

                // then we want to make a request here..
                editable?.let {
                    if (editable.toString().isNotEmpty()) {

                        viewModel.searchNews(editable.toString())

                        delay(3000)
                        job?.cancel()

                    } else {
                        delay(3000)
                        job?.cancel()
                    }
                }
            }
        }

        /** Very similar to 'BreakingNewsFragment' */
        viewModel.searchNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                // CASE 1:
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles.toList())   // toList() works, but Mutable List doesn't work... why??

                        // to cover 'round-off' effect + 'last page of response is always
                        // empty and we don't want to consider that... so add 1 more'
                        val totalPages = newsResponse.totalResults / Constants.QUERY_PAGE_SIZE + 2
                        isLastPage = viewModel.searchNewsPage == totalPages       // then we are at the last page

                        // no padding at the bottom of the page (for visual reasons)
                        if (isLastPage) {
                            rvBreakingNews.setPadding(0, 0, 0, 0)
                        }
                    }
                }

                // CASE 2:
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {message ->
                        dialogger()
                    }
                }

                // CASE 3:
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })

        btn_speaker.setOnClickListener {
            Toast.makeText(activity, "Speak any keyword for finding articles in ENGLISH...", Toast.LENGTH_LONG).show()
            val sttIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

            sttIntent.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )

            sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            sttIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now!")

            try {
                startActivityForResult(sttIntent, MainActivity.Flagger.REQUEST_CODE_STT)

            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
                Toast.makeText(activity, "Your device does not support STT.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun dialogger(){
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(activity)

        // set message of alert dialog
        dialogBuilder.setMessage("Requests overloaded (up to 5 requests at a time), do you want to refresh?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, id ->

                val intent = Intent(activity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                (activity as NewsActivity).finish()

            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle(Html.fromHtml("<font color='#1CB093'>Requests Overloaded </font>"))
        // show alert dialog
        alert.show()
    }


    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.INVISIBLE
        isLoading = false       // pagination
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
        isLoading = true        // pagination
    }

    // for pagination (ie. reaching the end of the list)
    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    // scroll-listener for Recycler-View
    val scrollListener = object : RecyclerView.OnScrollListener() {

        // override method #1
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            // manually checks if we reached the bottom of the recycler-view
            // init layout-Manager && 3 fields for calculation (to check if we reached the bottom)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            // booleans... (needed for conditions-checking below)
            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtBeginning = firstVisibleItemPosition >= 0                 // if we scrolled down a bit so that the first one is not visible...
            val isTotalMoreThanVisible = totalItemCount >= Constants.QUERY_PAGE_SIZE       // each page consists of 20...
            val shouldPaginate = isNotLoadingAndNotLastPage &&                   // setting 5 conditions to perform pagination...
                    isAtLastItem && isNotAtBeginning &&
                    isTotalMoreThanVisible && isScrolling

            // if 5 boolean-cases hold true...
            if(shouldPaginate) {

                // ★★★★★★★★★ then call the 'key-function' with US
                viewModel.searchNews(etSearch.text.toString())         // i) perform the query
                isScrolling = false                                 // ii) reset the state!
            }
        }

        // override method #2
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            // Case 1: see if we are CURRENTLY-SCROLLING...
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }
    }



    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        rvSearchNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(this@SearchNewsFragment.scrollListener)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            MainActivity.Flagger.REQUEST_CODE_STT -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    result?.let {
                        val recognizedText = it[0]
                        etSearch.setText(recognizedText)
                    }
                }
            }
        }
    }

}

