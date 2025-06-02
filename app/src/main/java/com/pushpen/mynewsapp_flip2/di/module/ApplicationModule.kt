package com.pushpen.mynewsapp_flip2.di.module

import android.content.Context
import com.pushpen.mynewsapp_flip2.Data.DataHelper
import com.pushpen.mynewsapp_flip2.MyApplication
import com.pushpen.mynewsapp_flip2.data.api.NetworkService
import com.pushpen.mynewsapp_flip2.di.ApplicationContext
import com.pushpen.mynewsapp_flip2.di.BaseUrl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(var application: MyApplication){

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataHelper(): DataHelper {
        return  DataHelper()
    }


    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }
}
