package net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen

data class InvoiceItemAddUiState(
    val productName: String = "",
    val productPrice: String = "",
    val productUnit: String = "",
    val amountDiscount: Int = 0,
    val percentDiscount: Double = 0.0
)
