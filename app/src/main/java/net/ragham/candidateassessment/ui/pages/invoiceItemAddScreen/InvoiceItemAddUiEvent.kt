package net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen

sealed class InvoiceItemAddUiEvent{
    data class ProductNameChanged(val productName: String): InvoiceItemAddUiEvent()
    data class ProductUnitPriceChanged(val productPrice: String): InvoiceItemAddUiEvent()
    data class ProductUnitChanged(val productUnit: String): InvoiceItemAddUiEvent()
    data class ProductPercentDiscountChanged(val productPercentDiscount: String): InvoiceItemAddUiEvent()
    data class ProductAmountDiscountChanged(val productAmountDiscount: String): InvoiceItemAddUiEvent()

    object AddProduct: InvoiceItemAddUiEvent()

}