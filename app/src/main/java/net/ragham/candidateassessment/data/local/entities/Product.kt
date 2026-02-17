package net.ragham.candidateassessment.data.local.entities

data class Product(
    val product_name: String,
    val quantity: Double,
    val unit: String,
    val discont_pecent: Double,
    val discount_amount: Int,
)
