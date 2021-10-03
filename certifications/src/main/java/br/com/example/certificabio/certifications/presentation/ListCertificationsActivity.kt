package br.com.example.certificabio.certifications.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.example.certificabio.certifications.presentation.ListCertificationsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCertificationsActivity : AppCompatActivity() {

    private val viewModel by viewModels<ListCertificationsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
    }
}