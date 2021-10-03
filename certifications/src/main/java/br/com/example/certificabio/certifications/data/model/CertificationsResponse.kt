package br.com.example.certificabio.certifications.data.model

data class CertificationsResponse(
    val address: Address,
    val certifications: List<Certification>,
    val companyCnpj: String,
    val companyName: String
)

data class Address(
    val city: String,
    val district: String,
    val number: String,
    val state: String,
    val street: String,
    val zipCode: String
)

data class Certification(
    val guid: String
)