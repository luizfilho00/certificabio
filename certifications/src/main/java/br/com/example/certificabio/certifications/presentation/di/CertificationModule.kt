package br.com.example.certificabio.certifications.presentation.di

import br.com.example.certificabio.certifications.BuildConfig
import br.com.example.certificabio.certifications.data.network.ApiService
import br.com.example.certificabio.certifications.data.repository.IListCertificationsRepository
import br.com.example.certificabio.certifications.data.repository.ListCertificationsRepository
import br.com.example.certificabio.certifications.domain.IListCertificationsInteractor
import br.com.example.certificabio.certifications.domain.ListCertificationsInteractor
import br.com.example.certificabio.networkcore.service.RetrofitBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
abstract class CertificationModule {

    @Binds
    abstract fun bindsInteractor(impl: ListCertificationsInteractor): IListCertificationsInteractor

    @Binds
    abstract fun bindsRepository(impl: ListCertificationsRepository): IListCertificationsRepository

    companion object {
        @Provides
        fun provideService(builder: RetrofitBuilder): ApiService {
            return builder.buildService(
                baseUrl = "https://615954e6601e6f0017e5a15f.mockapi.io/api/v1/",
                serviceClass = ApiService::class.java,
                loggingLevel = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            )
        }
    }
}