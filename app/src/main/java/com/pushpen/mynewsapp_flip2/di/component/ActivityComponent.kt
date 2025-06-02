package com.example.mynewsapp_flip.di.component

import com.pushpen.mynewsapp_flip2.di.ActivityScope
import com.pushpen.mynewsapp_flip2.di.module.ActivityModule
import com.pushpen.mynewsapp_flip2.ui.topheadline.TopHeadlineActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)

}