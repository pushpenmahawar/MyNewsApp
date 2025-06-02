package com.pushpen.mynewsapp_flip2

import android.app.Application
import android.util.Log
import com.example.mynewsapp_flip.di.component.ApplicationComponent
import com.example.mynewsapp_flip.di.component.DaggerApplicationComponent
import com.pushpen.mynewsapp_flip2.Data.DataHelper
import com.pushpen.mynewsapp_flip2.di.module.ApplicationModule
import javax.inject.Inject

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var dataHelper: DataHelper


    override fun onCreate() {
        super.onCreate()

        injectDependencies()

        Log.d("newsApplication", dataHelper.hashCode().toString())
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}