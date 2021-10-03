package br.com.example.certificabio.certifications.data.repository

import br.com.example.certificabio.certifications.data.model.CertificationsResponse
import br.com.example.certificabio.certifications.data.network.ApiService
import io.reactivex.Single
import javax.inject.Inject

interface IListCertificationsRepository {
    fun getCertifications(): Single<List<CertificationsResponse>>
}

class ListCertificationsRepository @Inject constructor(
    private val service: ApiService
) : IListCertificationsRepository {

    override fun getCertifications(): Single<List<CertificationsResponse>> {
        return service.getCertifications()
    }
}