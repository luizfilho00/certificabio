package br.com.example.certificabio.certifications.presentation

import androidx.lifecycle.ViewModel
import br.com.example.certificabio.certifications.domain.IListCertificationsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ListCertificationsViewModel @Inject constructor(
    private val interactor: IListCertificationsInteractor
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    init {
        interactor
            .getCertifications()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { println(it) },
                onError = { it.printStackTrace() }
            )
            .addTo(compositeDisposable)
    }
}