package net.ragham.candidateassessment.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoice")
data class Invoice(
    @PrimaryKey
    val invoice_id: String,
    //buyer details
    val buyer_name: String,
    val buyer_mobile: String,
    //seller details
    val seller_name: String,
    val seller_mobile: String,

    // product
    val product: List<Product>

)
