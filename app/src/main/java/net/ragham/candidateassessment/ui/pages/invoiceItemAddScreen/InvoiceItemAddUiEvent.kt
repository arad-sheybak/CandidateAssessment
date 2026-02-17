package net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen

sealed class InvoiceItemAddUiEvent{
    data class ProductNameChanged(val productName: String): InvoiceItemAddUiEvent()

    data class ProductUnitPriceChanged(val productPrice: Double): InvoiceItemAddUiEvent()

    data class ProductUnitChanged(val productUnit: String): InvoiceItemAddUiEvent()

    data class ProductPercentDiscountChanged(val productPercentDiscount: Double): InvoiceItemAddUiEvent()

    data class ProductAmountDiscountChanged(val productAmountDiscount: Int): InvoiceItemAddUiEvent()

    object AddProduct: InvoiceItemAddUiEvent()

}