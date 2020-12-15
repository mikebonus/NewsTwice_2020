package com.manhee.newsapp_2020_mk.repository;

import java.lang.System;

/**
 * By default, constructor-param on view-models cannot be done
 * So to do that, we need to create 'ViewModelProviderFactory'
 * to pass 'Repository' in the constructor
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010\u000b\u001a\u00020#2\u0006\u0010&\u001a\u00020\'J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0*0)J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0-H\u0002J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0-H\u0002J\b\u0010/\u001a\u000200H\u0002J\u0019\u00101\u001a\u0002022\u0006\u0010&\u001a\u00020\'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103J\u0019\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\'H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103J\u000e\u00106\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010\u001a\u001a\u00020#2\u0006\u00105\u001a\u00020\'R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "newsRepository", "Lcom/manhee/newsapp_2020_mk/repository/NewsRepository;", "(Landroid/app/Application;Lcom/manhee/newsapp_2020_mk/repository/NewsRepository;)V", "breakingNews", "Landroidx/lifecycle/MutableLiveData;", "Lcom/manhee/newsapp_2020_mk/ui/Resource;", "Lcom/manhee/newsapp_2020_mk/ui/NewsResponse;", "getBreakingNews", "()Landroidx/lifecycle/MutableLiveData;", "breakingNewsPage", "", "getBreakingNewsPage", "()I", "setBreakingNewsPage", "(I)V", "breakingNewsResponse", "getBreakingNewsResponse", "()Lcom/manhee/newsapp_2020_mk/ui/NewsResponse;", "setBreakingNewsResponse", "(Lcom/manhee/newsapp_2020_mk/ui/NewsResponse;)V", "getNewsRepository", "()Lcom/manhee/newsapp_2020_mk/repository/NewsRepository;", "searchNews", "getSearchNews", "searchNewsPage", "getSearchNewsPage", "setSearchNewsPage", "searchNewsResponse", "getSearchNewsResponse", "setSearchNewsResponse", "deleteArticle", "Lkotlinx/coroutines/Job;", "article", "Lcom/manhee/newsapp_2020_mk/ui/Article;", "countryCode", "", "getSavedNews", "Landroidx/lifecycle/LiveData;", "", "handleBreakingNewsResponse", "response", "Lretrofit2/Response;", "handleSearchNewsResponse", "hasInternetConnection", "", "safeBreakingNewsCall", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeSearchNewsCall", "searchQuery", "saveArticle", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.manhee.newsapp_2020_mk.ui.Resource<com.manhee.newsapp_2020_mk.ui.NewsResponse>> breakingNews = null;
    private int breakingNewsPage = 1;
    @org.jetbrains.annotations.Nullable()
    private com.manhee.newsapp_2020_mk.ui.NewsResponse breakingNewsResponse;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.manhee.newsapp_2020_mk.ui.Resource<com.manhee.newsapp_2020_mk.ui.NewsResponse>> searchNews = null;
    private int searchNewsPage = 1;
    @org.jetbrains.annotations.Nullable()
    private com.manhee.newsapp_2020_mk.ui.NewsResponse searchNewsResponse;
    @org.jetbrains.annotations.NotNull()
    private final com.manhee.newsapp_2020_mk.repository.NewsRepository newsRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.manhee.newsapp_2020_mk.ui.Resource<com.manhee.newsapp_2020_mk.ui.NewsResponse>> getBreakingNews() {
        return null;
    }
    
    public final int getBreakingNewsPage() {
        return 0;
    }
    
    public final void setBreakingNewsPage(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.manhee.newsapp_2020_mk.ui.NewsResponse getBreakingNewsResponse() {
        return null;
    }
    
    public final void setBreakingNewsResponse(@org.jetbrains.annotations.Nullable()
    com.manhee.newsapp_2020_mk.ui.NewsResponse p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.manhee.newsapp_2020_mk.ui.Resource<com.manhee.newsapp_2020_mk.ui.NewsResponse>> getSearchNews() {
        return null;
    }
    
    public final int getSearchNewsPage() {
        return 0;
    }
    
    public final void setSearchNewsPage(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.manhee.newsapp_2020_mk.ui.NewsResponse getSearchNewsResponse() {
        return null;
    }
    
    public final void setSearchNewsResponse(@org.jetbrains.annotations.Nullable()
    com.manhee.newsapp_2020_mk.ui.NewsResponse p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBreakingNews(@org.jetbrains.annotations.NotNull()
    java.lang.String countryCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job searchNews(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery) {
        return null;
    }
    
    private final com.manhee.newsapp_2020_mk.ui.Resource<com.manhee.newsapp_2020_mk.ui.NewsResponse> handleBreakingNewsResponse(retrofit2.Response<com.manhee.newsapp_2020_mk.ui.NewsResponse> response) {
        return null;
    }
    
    private final com.manhee.newsapp_2020_mk.ui.Resource<com.manhee.newsapp_2020_mk.ui.NewsResponse> handleSearchNewsResponse(retrofit2.Response<com.manhee.newsapp_2020_mk.ui.NewsResponse> response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveArticle(@org.jetbrains.annotations.NotNull()
    com.manhee.newsapp_2020_mk.ui.Article article) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.manhee.newsapp_2020_mk.ui.Article>> getSavedNews() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteArticle(@org.jetbrains.annotations.NotNull()
    com.manhee.newsapp_2020_mk.ui.Article article) {
        return null;
    }
    
    private final boolean hasInternetConnection() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.manhee.newsapp_2020_mk.repository.NewsRepository getNewsRepository() {
        return null;
    }
    
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.manhee.newsapp_2020_mk.repository.NewsRepository newsRepository) {
        super(null);
    }
}