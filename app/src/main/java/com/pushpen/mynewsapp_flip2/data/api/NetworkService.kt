package com.pushpen.mynewsapp_flip2.data.api

import com.pushpen.mynewsapp_flip2.data.model.TopHeadlinesResponse
import com.pushpen.mynewsapp_flip2.utils.AppConstant
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @Headers("X-Api-Key: ${AppConstant.API_KEY}"  , "User-Agent:abc" )
    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): TopHeadlinesResponse

}