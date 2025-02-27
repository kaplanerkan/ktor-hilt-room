package com.android.roomtest

import android.app.Application
import android.webkit.WebView
import androidx.lifecycle.LifecycleObserver
import com.android.roomtest.dataservice.KtorApplication
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class TestApplication : Application(),
    LifecycleObserver {

    @Inject
    lateinit var ktorApplication: KtorApplication
    override fun onCreate() {
        super.onCreate()

        ktorApplication.startServer(this)
        WebView.setWebContentsDebuggingEnabled(true);
    }


}