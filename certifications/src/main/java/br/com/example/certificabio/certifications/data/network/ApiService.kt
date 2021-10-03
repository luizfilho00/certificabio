package br.com.example.certificabio.certifications.data.network

import br.com.example.certificabio.certifications.data.model.CertificationsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/list")
    fun getCertifications(): Single<List<CertificationsResponse>>
}