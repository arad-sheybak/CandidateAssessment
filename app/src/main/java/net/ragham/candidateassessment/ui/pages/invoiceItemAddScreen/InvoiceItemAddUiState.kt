package net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen

data class InvoiceItemAddUiState(
    val productName: String = "",
    val productQuantity:Double = 0.0,
    val productPrice: Int = 0,
    val productUnit: String = "",
    val amountDiscount: Int = 0,
    val percentDiscount: Double = 0.0,
    val isProductNameValidate : Boolean = false,
    val isProductPriceValidate: Boolean = false,
    val isFormValid : Boolean = false
)
