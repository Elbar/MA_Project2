package com.example.ma_project2.example_for_retrofit.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {

    private const val BASE_URL = "http://e11837c0.ngrok.io/"

    //create Logger
    private val logger=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // create okHttp Client
    private val okHttp:OkHttpClient.Builder = OkHttpClient.Builder().callTimeout(15,TimeUnit.SECONDS).addInterceptor(logger)

    //Create retrofit instance
    private val builder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL ).addConverterFactory(GsonConverterFactory.create())
                                                      .client(okHttp.build())

    //Create retrofit instance
    private val retrofit:Retrofit = builder.build()

    fun <T> builService(serviceType: Class<T>):T{
        return retrofit.create(serviceType)
    }
}