package net.ragham.candidateassessment.ui.pages.invoiceEditor

data class InvoiceEditorUiState(
    val sellerName: String = "",
    val sellerMobile:String = "",
    val buyerName:String = "",
    val buyerMobile:String = "",
    val isSellerInfoValid : Boolean = false,
    val isBuyerInfoValid: Boolean = false,
    val isFormValid: Boolean = false
)
