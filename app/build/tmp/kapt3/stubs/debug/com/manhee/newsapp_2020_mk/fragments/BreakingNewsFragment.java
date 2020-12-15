package com.manhee.newsapp_2020_mk.fragments;

import java.lang.System;

/**
 * LiveData will notify the changes happening to it to this fragment
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u001a\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006*"}, d2 = {"Lcom/manhee/newsapp_2020_mk/fragments/BreakingNewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isLastPage", "", "()Z", "setLastPage", "(Z)V", "isLoading", "setLoading", "isScrolling", "setScrolling", "newsAdapter", "Lcom/androiddevs/mvvmnewsapp/api/NewsAdapter;", "getNewsAdapter", "()Lcom/androiddevs/mvvmnewsapp/api/NewsAdapter;", "setNewsAdapter", "(Lcom/androiddevs/mvvmnewsapp/api/NewsAdapter;)V", "scrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "viewModel", "Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;", "getViewModel", "()Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;", "setViewModel", "(Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;)V", "dialoggerBreakingNews", "", "hideProgressBar", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "showProgressBar", "app_debug"})
public final class BreakingNewsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.manhee.newsapp_2020_mk.repository.NewsViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    public com.androiddevs.mvvmnewsapp.api.NewsAdapter newsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "Breaking News Fragment";
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private boolean isScrolling = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.recyclerview.widget.RecyclerView.OnScrollListener scrollListener = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.manhee.newsapp_2020_mk.repository.NewsViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.manhee.newsapp_2020_mk.repository.NewsViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.androiddevs.mvvmnewsapp.api.NewsAdapter getNewsAdapter() {
        return null;
    }
    
    public final void setNewsAdapter(@org.jetbrains.annotations.NotNull()
    com.androiddevs.mvvmnewsapp.api.NewsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void hideProgressBar() {
    }
    
    private final void showProgressBar() {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final void setLoading(boolean p0) {
    }
    
    public final boolean isLastPage() {
        return false;
    }
    
    public final void setLastPage(boolean p0) {
    }
    
    public final boolean isScrolling() {
        return false;
    }
    
    public final void setScrolling(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.OnScrollListener getScrollListener() {
        return null;
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void dialoggerBreakingNews() {
    }
    
    public BreakingNewsFragment() {
        super();
    }
}