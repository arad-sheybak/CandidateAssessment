package net.ragham.candidateassessment.ui.pages.invoiceEditor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collectLatest
import net.ragham.candidateassessment.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun InvoiceEditorScreen(
    viewModel: InvoiceEditorViewModel = koinViewModel(),
    onAddProductClicked: () -> Unit = {},
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.eventShared.collectLatest { event ->
            when (event) {
                is InvoiceEditorEvent.NavigateToInvoiceAddItem -> {
                    navController.navigate(Screen.InvoiceItemAdd.route)
                }
            }
        }
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
            .background(color = Color.White)
    ) {

        val (sellerSectionTxt,
            sellerFullNameInput,
            sellerMobileInput,
            buyerSectionTxt,
            buyerFullNameInput,
            buyerMobileInput,
            btnAddProduct) = createRefs()

        Text(
            text = "فروشنده",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .constrainAs(sellerSectionTxt) {
                    top.linkTo(parent.top)
                    end.linkTo(
                        parent.end
                    )

                }
        )

        OutlinedTextField(
            value = uiState.sellerName,
            onValueChange = {
                viewModel.handleUiEvent(InvoiceEditorUiEvent.SellerNameChanged(sellerName = it))
            },
            label = {
                Text("نام و نام خانوادگی فروشنده")
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .constrainAs(sellerFullNameInput) {
                    top.linkTo(sellerSectionTxt.bottom, margin = 8.dp)
                    end.linkTo(parent.end)
                }

        )

        OutlinedTextField(
            value = uiState.sellerMobile,
            onValueChange = {
                viewModel.handleUiEvent(InvoiceEditorUiEvent.SellerMobileChanged(sellerMobile = it))
            },
            label = { Text("موبایل فروشنده") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .constrainAs(sellerMobileInput) {
                    top.linkTo(sellerFullNameInput.bottom, margin = 16.dp)
                    end.linkTo(parent.end)

                }
        )

        Text(
            text = "خریدار",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .constrainAs(buyerSectionTxt) {
                    top.linkTo(sellerMobileInput.bottom, margin = 16.dp)
                    end.linkTo(
                        parent.end
                    )

                }
        )

        OutlinedTextField(
            value = uiState.buyerName,
            onValueChange = {
                viewModel.handleUiEvent(InvoiceEditorUiEvent.BuyerNameChanged(buyerName = it))
            },
            label = {
                Text("نام و نام خانوادگی خریدار")
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .constrainAs(buyerFullNameInput) {
                    top.linkTo(buyerSectionTxt.bottom, margin = 8.dp)
                    end.linkTo(parent.end)
                }

        )

        OutlinedTextField(
            value = uiState.buyerMobile,
            onValueChange = {
                viewModel.handleUiEvent(InvoiceEditorUiEvent.BuyerMobileChanged(buyerMobile = it))
            },
            label = { Text("موبایل خریدار") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .constrainAs(buyerMobileInput) {
                    top.linkTo(buyerFullNameInput.bottom, margin = 16.dp)
                    end.linkTo(parent.end)

                }
        )
        Button(
            onClick = {
                //navigate to InvoiceItemAddScreen
                viewModel.handleUiEvent(InvoiceEditorUiEvent.AddProductClicked)
                if (uiState.isFormValid) {
                    onAddProductClicked()
                }

            },
            modifier = Modifier.constrainAs(btnAddProduct) {
                top.linkTo(buyerMobileInput.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text("افزودن محصول")
        }
    }
}
