package com.manhee.newsapp_2020_mk.fragments;

import java.lang.System;

/**
 * LiveData will notify the changes happening to it to this fragment..
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/manhee/newsapp_2020_mk/fragments/SavedNewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "newsAdapter", "Lcom/androiddevs/mvvmnewsapp/api/NewsAdapter;", "getNewsAdapter", "()Lcom/androiddevs/mvvmnewsapp/api/NewsAdapter;", "setNewsAdapter", "(Lcom/androiddevs/mvvmnewsapp/api/NewsAdapter;)V", "viewModel", "Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;", "getViewModel", "()Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;", "setViewModel", "(Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "app_debug"})
public final class SavedNewsFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.manhee.newsapp_2020_mk.repository.NewsViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    public com.androiddevs.mvvmnewsapp.api.NewsAdapter newsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "Saved News Fragment";
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
    
    private final void setupRecyclerView() {
    }
    
    public SavedNewsFragment() {
        super();
    }
}