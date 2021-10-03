package br.com.example.certificabio.networkcore.di

import br.com.example.certificabio.networkcore.service.IRetrofitBuilder
import br.com.example.certificabio.networkcore.service.RetrofitBuilder
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModuleBuilder {
    @Binds
    fun bindsRetrofit(impl: RetrofitBuilder): IRetrofitBuilder
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"

    @Provides
    fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().serializeNulls().setDateFormat(API_DATE_FORMAT).create()
}
