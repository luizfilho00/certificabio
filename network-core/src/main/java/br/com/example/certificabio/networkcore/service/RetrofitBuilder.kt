package br.com.example.certificabio.networkcore.service

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface IRetrofitBuilder {
    fun <T> buildService(
        baseUrl: String,
        serviceClass: Class<T>,
        loggingLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
    ): T
}

class RetrofitBuilder @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val gson: Gson
) : IRetrofitBuilder {

    override fun <T> buildService(
        baseUrl: String,
        serviceClass: Class<T>,
        loggingLevel: HttpLoggingInterceptor.Level
    ): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .run { create(serviceClass) }
    }
}