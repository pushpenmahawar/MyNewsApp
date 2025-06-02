package com.example.mynewsapp_flip.di.component

import android.app.Application
import android.content.Context
import com.pushpen.mynewsapp_flip2.MyApplication
import com.pushpen.mynewsapp_flip2.data.api.NetworkService
import com.pushpen.mynewsapp_flip2.data.repository.TopHeadlineRepository
import com.pushpen.mynewsapp_flip2.di.ApplicationContext
import com.pushpen.mynewsapp_flip2.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)


    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository

}