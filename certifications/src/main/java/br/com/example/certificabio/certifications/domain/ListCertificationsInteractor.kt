package br.com.example.certificabio.certifications.domain

import br.com.example.certificabio.certifications.data.model.CertificationsResponse
import br.com.example.certificabio.certifications.data.repository.IListCertificationsRepository
import io.reactivex.Single
import javax.inject.Inject

interface IListCertificationsInteractor {
    fun getCertifications(): Single<List<CertificationsResponse>>
}

class ListCertificationsInteractor @Inject constructor(
    private val repository: IListCertificationsRepository
) : IListCertificationsInteractor {

    override fun getCertifications(): Single<List<CertificationsResponse>> {
        return repository.getCertifications()
    }
}