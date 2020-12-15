package com.manhee.newsapp_2020_mk.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.mvvmnewsapp.api.NewsAdapter
import com.google.android.material.snackbar.Snackbar
import com.manhee.newsapp_2020_mk.R
import com.manhee.newsapp_2020_mk.repository.NewsViewModel
import com.manhee.newsapp_2020_mk.NewsActivity
import kotlinx.android.synthetic.main.fragment_saved_news.*

/** LiveData will notify the changes happening to it to this fragment.. */
class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {

    // to connect this fragment with the view-model
    // in which the (view-model-provider-factory has allowed the repository in the viewModel's constructor)
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "Saved News Fragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        // do this before fragment-transition (ie. target destination is 'Article-Fragment')
        // (ie. This 'article' comes from the fact that 'Article' in <Model> is 'serializable')
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)      // it ---> remember that we ADDED ARGUMENTS in navgiation-graph-settings
            }

            // Target is 'Article-Fragment'
            // (ie. add bundle to nav-component && send all the bundles to 'Article-Fragment')
            // (This is done through navigation-component-library)
            findNavController().navigate(
                R.id.action_savedNewsFragment_to_articleFragment,
                bundle
            )
        }

        // Swiping Left/Right to delete a news from the Recycler-View
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            // function #1
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            // function #2
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition       // position to be deleted...
                val article = newsAdapter.differ.currentList[position]      // corresponding article to be deleted inside the DB

                // Delete-Operation done here... (MVVM)
                viewModel.deleteArticle(article)

                // remove that article with that particular address...
                ArticleFragment.UniqueSaver
                    .seta
                    .remove(article.url.toString())




                Snackbar.make(view, "Successfully deleted article", Snackbar.LENGTH_LONG).apply {

                    // if you click 'undo' tag...
                    setAction("Undo") {
                        // Save-Operation done here... (MVVM)
                        viewModel.saveArticle(article)
                    }
                    show()      // show the snack-bar
                }
            }
        }

        // Finish the ItemTouchHelper
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(rvSavedNews)
        }

        // Whenever data in the DB changes...
        // Save-Operation Performed Here (MVVM)
        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer { articles ->
            newsAdapter.differ.submitList(articles)
        })



    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}