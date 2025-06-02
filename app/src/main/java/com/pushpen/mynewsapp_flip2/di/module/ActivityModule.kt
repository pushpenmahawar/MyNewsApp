package com.pushpen.mynewsapp_flip2.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pushpen.mynewsapp_flip2.data.repository.TopHeadlineRepository
import com.pushpen.mynewsapp_flip2.di.ActivityContext
import com.pushpen.mynewsapp_flip2.ui.base.ViewModelProviderFactory
import com.pushpen.mynewsapp_flip2.ui.topheadline.TopHeadlineAdapter
import com.pushpen.mynewsapp_flip2.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideNewsListViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())

}