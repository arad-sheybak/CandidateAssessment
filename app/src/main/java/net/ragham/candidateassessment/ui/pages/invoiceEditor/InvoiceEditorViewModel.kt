package net.ragham.candidateassessment.ui.pages.invoiceEditor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InvoiceEditorViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(InvoiceEditorUiState())
    val uiState: StateFlow<InvoiceEditorUiState> = _uiState.asStateFlow()

    private val _eventShared = MutableSharedFlow<InvoiceEditorEvent>()
    val eventShared = _eventShared.asSharedFlow()

    fun handleUiEvent(event: InvoiceEditorUiEvent) {
        when (event) {
            is InvoiceEditorUiEvent.SellerNameChanged -> {
                _uiState.update {
                    it.copy(
                        sellerName = event.sellerName,
                        isSellerInfoValid = validateSellerInfo(
                            event.sellerName,
                            it.sellerMobile
                        )
                    ).also { updatedState ->
                        updateFormValidate(updatedState)
                    }
                }

            }

            is InvoiceEditorUiEvent.SellerMobileChanged -> {
                _uiState.update {
                    it.copy(
                        sellerMobile = event.sellerMobile,
                        isSellerInfoValid = validateSellerInfo(
                            it.sellerName,
                            event.sellerMobile
                        )
                    ).also { updatedState ->
                        updateFormValidate(updatedState)
                    }
                }

            }

            is InvoiceEditorUiEvent.BuyerNameChanged -> {
                _uiState.update {
                    it.copy(
                        buyerName = event.buyerName,
                        isBuyerInfoValid = validateBuyerInfo(event.buyerName, it.buyerMobile)
                    ).also { updatedState ->
                        updateFormValidate(updatedState)
                    }
                }
            }

            is InvoiceEditorUiEvent.BuyerMobileChanged -> {
                _uiState.update {
                    it.copy(
                        buyerMobile = event.buyerMobile,
                        isBuyerInfoValid = validateBuyerInfo(it.buyerName, event.buyerMobile)
                    ).also { updatedState ->
                        updateFormValidate(updatedState)
                    }
                }

            }

            is InvoiceEditorUiEvent.AddProductClicked -> {
                //navigate to InvoiceAddItem
                viewModelScope.launch {
                    _eventShared.emit(InvoiceEditorEvent.NavigateToInvoiceAddItem)
                }
            }
        }
    }

    private fun validateSellerInfo(sellerName: String, sellerMobile: String): Boolean {
        return sellerName.isNotBlank() && sellerMobile.isNotBlank() && sellerMobile.length == 11
    }

    private fun validateBuyerInfo(buyerName: String, buyerMobile: String): Boolean {
        return buyerName.isNotBlank() && buyerMobile.isNotBlank() && buyerMobile.length == 11
    }

    private fun updateFormValidate(state: InvoiceEditorUiState) {
        _uiState.update { it.copy(isFormValid = state.isSellerInfoValid && state.isBuyerInfoValid) }

    }
}