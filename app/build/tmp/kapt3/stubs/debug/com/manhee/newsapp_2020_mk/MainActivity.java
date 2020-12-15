package com.manhee.newsapp_2020_mk;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/manhee/newsapp_2020_mk/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mAdView", "Lcom/google/android/gms/ads/AdView;", "getMAdView", "()Lcom/google/android/gms/ads/AdView;", "setMAdView", "(Lcom/google/android/gms/ads/AdView;)V", "mInterstitialAd", "Lcom/google/android/gms/ads/InterstitialAd;", "getMInterstitialAd", "()Lcom/google/android/gms/ads/InterstitialAd;", "setMInterstitialAd", "(Lcom/google/android/gms/ads/InterstitialAd;)V", "moveToNextActivity", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Flagger", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.ads.AdView mAdView;
    @org.jetbrains.annotations.NotNull()
    public com.google.android.gms.ads.InterstitialAd mInterstitialAd;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.ads.AdView getMAdView() {
        return null;
    }
    
    public final void setMAdView(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.AdView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.ads.InterstitialAd getMInterstitialAd() {
        return null;
    }
    
    public final void setMInterstitialAd(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.InterstitialAd p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void moveToNextActivity() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/manhee/newsapp_2020_mk/MainActivity$Flagger;", "", "()V", "Companion", "app_debug"})
    public static final class Flagger {
        @org.jetbrains.annotations.NotNull()
        private static java.lang.String output = "";
        @org.jetbrains.annotations.NotNull()
        private static java.lang.String FLAG = "";
        public static final int REQUEST_CODE_STT = 1;
        public static final com.manhee.newsapp_2020_mk.MainActivity.Flagger.Companion Companion = null;
        
        public Flagger() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/manhee/newsapp_2020_mk/MainActivity$Flagger$Companion;", "", "()V", "FLAG", "", "getFLAG", "()Ljava/lang/String;", "setFLAG", "(Ljava/lang/String;)V", "REQUEST_CODE_STT", "", "output", "getOutput", "setOutput", "app_debug"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getOutput() {
                return null;
            }
            
            public final void setOutput(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getFLAG() {
                return null;
            }
            
            public final void setFLAG(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            private Companion() {
                super();
            }
        }
    }
}