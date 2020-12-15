package com.androiddevs.mvvmnewsapp.api

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manhee.newsapp_2020_mk.R
import com.manhee.newsapp_2020_mk.ui.Article
import kotlinx.android.synthetic.main.item_article_preview.view.*


class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    // View-Holder
    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    // DiffUtils (which compares the existing list with the new list to update the list)
    // Happens in the background and is very efficient
    private val differCallback = object : DiffUtil.ItemCallback<Article>() {

        // function #1
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        // function #2
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    // AsyncListDiffer runs in the background
    // (compares the two lists to see if there is a differene, and update the list)..
    val differ = AsyncListDiffer(this, differCallback)

    // Override Method #1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    // Override Method #2
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    // Override Method #3
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]

        holder.itemView.apply {

            // Glide-Image
            // default images... (included now)
            Glide.with(this)
                .load(article.urlToImage)
                .placeholder(R.mipmap.newsplacer)
                .error(R.mipmap.newsplacer)
                .into(ivArticleImage)

            // TextViews per Item
            tvSource.text = article.source?.name
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvPublishedAt.text = article.publishedAt

            // onclicklistener for each item.. (from below)
            setOnClickListener {
                onItemClickListener?.let { it(article) }

                // 'it' refers to 'onItemClickListener' below
            }
        }
    }

    // for opening the correct web-view
    // to hit a single item from the list (open correct webview page)
    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }
}













