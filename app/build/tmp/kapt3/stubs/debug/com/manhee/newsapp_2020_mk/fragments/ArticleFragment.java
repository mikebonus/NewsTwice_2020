package com.manhee.newsapp_2020_mk.fragments;

import java.lang.System;

/**
 * LiveData will notify the changes happening to it to this fragment..
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/manhee/newsapp_2020_mk/fragments/ArticleFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/manhee/newsapp_2020_mk/fragments/ArticleFragmentArgs;", "getArgs", "()Lcom/manhee/newsapp_2020_mk/fragments/ArticleFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "viewModel", "Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;", "getViewModel", "()Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;", "setViewModel", "(Lcom/manhee/newsapp_2020_mk/repository/NewsViewModel;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "UniqueSaver", "app_debug"})
public final class ArticleFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.manhee.newsapp_2020_mk.repository.NewsViewModel viewModel;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.manhee.newsapp_2020_mk.repository.NewsViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.manhee.newsapp_2020_mk.repository.NewsViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.manhee.newsapp_2020_mk.fragments.ArticleFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public ArticleFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/manhee/newsapp_2020_mk/fragments/ArticleFragment$UniqueSaver;", "", "()V", "Companion", "app_debug"})
    public static final class UniqueSaver {
        @org.jetbrains.annotations.NotNull()
        private static final java.util.HashSet<java.lang.String> seta = null;
        @org.jetbrains.annotations.NotNull()
        private static java.lang.String uniqueArticle = "";
        public static final com.manhee.newsapp_2020_mk.fragments.ArticleFragment.UniqueSaver.Companion Companion = null;
        
        public UniqueSaver() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/manhee/newsapp_2020_mk/fragments/ArticleFragment$UniqueSaver$Companion;", "", "()V", "seta", "Ljava/util/HashSet;", "", "getSeta", "()Ljava/util/HashSet;", "uniqueArticle", "getUniqueArticle", "()Ljava/lang/String;", "setUniqueArticle", "(Ljava/lang/String;)V", "app_debug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.HashSet<java.lang.String> getSeta() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getUniqueArticle() {
                return null;
            }
            
            public final void setUniqueArticle(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            private Companion() {
                super();
            }
        }
    }
}