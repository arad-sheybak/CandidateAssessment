package net.ragham.candidateassessment.ui.pages.invoiceEditor

sealed class InvoiceEditorUiEvent {
    data class SellerNameChanged(val sellerName: String) : InvoiceEditorUiEvent()
    data class SellerMobileChanged(val sellerMobile: String) : InvoiceEditorUiEvent()

    data class BuyerNameChanged(val buyerName: String) : InvoiceEditorUiEvent()
    data class BuyerMobileChanged(val buyerMobile: String) : InvoiceEditorUiEvent()

    object AddProductClicked : InvoiceEditorUiEvent()
}