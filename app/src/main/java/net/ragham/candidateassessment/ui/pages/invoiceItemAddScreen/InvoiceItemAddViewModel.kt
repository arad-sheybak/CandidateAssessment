package net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.ragham.candidateassessment.ui.pages.invoiceEditor.InvoiceEditorUiState

class InvoiceItemAddViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(InvoiceItemAddUiState())
    val uiState: StateFlow<InvoiceItemAddUiState> = _uiState.asStateFlow()

    fun handleEvents(event: InvoiceItemAddUiEvent) {
        when (event) {
            is InvoiceItemAddUiEvent.ProductNameChanged -> {
                _uiState.update {
                    it.copy(
                        productName = event.productName,
                        isProductNameValidate = validateProductName(event.productName)
                    ).also {updatedState ->

                    }
                }
            }

            is InvoiceItemAddUiEvent.ProductUnitPriceChanged -> {
                _uiState.update {
                    it.copy(
                        productPrice = event.productPrice
                    )
                }
            }

            is InvoiceItemAddUiEvent.ProductUnitChanged -> {
                _uiState.update {
                    it.copy(
                        productUnit = event.productUnit
                    )
                }
            }

            is InvoiceItemAddUiEvent.ProductAmountDiscountChanged -> {
                _uiState.update {
                    it.copy(
                        amountDiscount = event.productAmountDiscount
                    )
                }

            }

            is InvoiceItemAddUiEvent.ProductPercentDiscountChanged -> {
                _uiState.update {
                    it.copy(
                        percentDiscount = event.productPercentDiscount
                    )
                }
            }

            is InvoiceItemAddUiEvent.AddProduct -> {

            }
        }
    }

    private fun validateProductName(productName:String):Boolean{
        return productName.isNotBlank() && productName.length >= 5
    }

    private fun validateProductPrice(price: Double): Boolean{
        return price.toString().isNotBlank() && price > 0
    }
    private fun updateFormValidate(state: InvoiceItemAddUiState) {
        _uiState.update { it.copy(isFormValid = state.isProductNameValidate && state.isProductPriceValidate) }

    }

    private fun calculatePercentDiscount(){
        val unitPrice=1000
        val quantity = 10
        val totalPrice = unitPrice * quantity
        val discount = 5 //discount who user entered based on percent
//        10000*0.05=50
        val amountPercent = totalPrice * (discount/100)
        val finalPrice = totalPrice - amountPercent
        9950

    }
    private fun calculateAmountToPercent(){
        val unitPrice=1000
        val quantity = 10
        val totalPrice = unitPrice * quantity
        val discount = 50
        val finalPrice = totalPrice- discount
//        val percent =

    }
}