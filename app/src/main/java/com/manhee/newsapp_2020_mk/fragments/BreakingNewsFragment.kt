package com.manhee.newsapp_2020_mk.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.AbsListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.mvvmnewsapp.api.NewsAdapter
import com.manhee.newsapp_2020_mk.MainActivity
import com.manhee.newsapp_2020_mk.R
import com.manhee.newsapp_2020_mk.repository.NewsViewModel
import com.manhee.newsapp_2020_mk.ui.Constants.Companion.QUERY_PAGE_SIZE
import com.manhee.newsapp_2020_mk.NewsActivity
import com.manhee.newsapp_2020_mk.ui.Constants
import com.manhee.newsapp_2020_mk.ui.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

/** LiveData will notify the changes happening to it to this fragment */
class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    // to connect this fragment with the view-model
    // in which the (view-model-provider-factory has allowed the repository in the viewModel's constructor)
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "Breaking News Fragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        // do this before fragment-transition (ie. target destination is 'Article-Fragment')
        // (ie. This 'article' comes from the fact that 'Article' in <Model> is 'serializable')
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable(
                    "article",
                    it
                )
            }

            // Target is 'Article-Fragment'
            // (ie. add bundle to nav-component && send all the bundles to 'Article-Fragment')
            // (This is done through navigation-component-library)
            findNavController().navigate(
                R.id.action_breakingNewsFragment_to_articleFragment,
                bundle
            )
        }

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                // CASE 1:
                is Resource.Success -> {
                    hideProgressBar()

                    response.data?.let { newsResponse ->
                        // toList() to continuously have more breaking news fill up the recycler-view...
                        // (ie. Mutable-List is not working...but why?)
                        newsAdapter.differ.submitList(newsResponse.articles.toList())

                        // to cover 'round-off' effect + 'last page of response is always
                        // empty and we don't want to consider that... so add 1 more'
                        val totalPages = newsResponse.totalResults / QUERY_PAGE_SIZE + 2
                        isLastPage =
                            viewModel.breakingNewsPage == totalPages       // then we are at the last page

                        // no padding at the bottom of the page (for visual reasons)
                        if (isLastPage) {
                            rvBreakingNews.setPadding(0, 0, 0, 0)
                        }
                    }
                }

                // CASE 2:
                is Resource.Error -> {
                    hideProgressBar()

                    if (Constants.API_KEY.equals(Constants.API_KEY_VER_1)) {
                        Constants.API_KEY = Constants.API_KEY_VER_2

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_2)) {
                        Constants.API_KEY = Constants.API_KEY_VER_3

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_3)) {
                        Constants.API_KEY = Constants.API_KEY_VER_4

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_4)) {
                        Constants.API_KEY = Constants.API_KEY_VER_5

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_5)) {
                        Constants.API_KEY = Constants.API_KEY_VER_6

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_6)) {
                        Constants.API_KEY = Constants.API_KEY_VER_7

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_7)) {
                        Constants.API_KEY = Constants.API_KEY_VER_8

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_8)) {
                        Constants.API_KEY = Constants.API_KEY_VER_9

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_9)) {
                        Constants.API_KEY = Constants.API_KEY_VER_10

                    } else if (Constants.API_KEY.equals(Constants.API_KEY_VER_10)) {
                        Constants.API_KEY = Constants.API_KEY_VER_1
                    }

                    // ★★★★★★★ gets called ★★★★★★★
                    // i) when there is NO internet connection...
                    // ii) when the query runs out...
                    response.message?.let { message ->
                        Toast.makeText(
                            activity,
                            "Network connection error occurred:::",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    dialoggerBreakingNews()
                }

                // CASE 3:
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
        isLoading = false       // for pagination
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
        isLoading = true            // for pagination
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

            // manually checks if we reached the bottom of the recycler-view..
            // init layout-Manager && 3 fields for calculation (to check if we reached the bottom)
            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            // booleans... (needed for conditions-checking below)
            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtBeginning =
                firstVisibleItemPosition >= 0                 // if we scrolled down a bit so that the first one is not visible...
            val isTotalMoreThanVisible =
                totalItemCount >= QUERY_PAGE_SIZE       // each page consists of 20...
            val shouldPaginate =
                isNotLoadingAndNotLastPage &&                   // setting 5 conditions to perform pagination...
                        isAtLastItem && isNotAtBeginning &&
                        isTotalMoreThanVisible && isScrolling

            // if 5 boolean-cases hold true...
            if (shouldPaginate) {

                // ★★★★★★★★★ then call the 'key-function' with US
                viewModel.getBreakingNews("us")         // i) perform the query
                isScrolling = false                                 // ii) reset the state!
            }
        }

        // override method #2
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            // Case 1: see if we are CURRENTLY-SCROLLING...
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }
    }


    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)

            // This part is for pagination...
            addOnScrollListener(this@BreakingNewsFragment.scrollListener)
        }
    }

    private fun dialoggerBreakingNews() {
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(activity)

        // set message of alert dialog
        dialogBuilder.setMessage("Network connection error occurred. Return to home screen?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->

                val intent = Intent(activity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                (activity as NewsActivity).finish()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle(Html.fromHtml("<font color='#1CB093'>Network Connection Error</font>"))
        // show alert dialog
        alert.show()
    }

}