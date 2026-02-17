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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun InvoiceEditorScreen() {
    InvoiceEditorUI()
}

@Composable
@Preview
private fun InvoiceEditorUI() {
    var sellerName by remember { mutableStateOf("") }
    var sellerMobile by remember { mutableStateOf("") }
    var buyerName by remember { mutableStateOf("") }
    var buyerMobile by remember { mutableStateOf("") }

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
            value = sellerName,
            onValueChange = {
                sellerName = it
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
            value = sellerMobile,
            onValueChange = {
                sellerMobile = it
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
            value = buyerName,
            onValueChange = {
                buyerName = it
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
            value = buyerMobile,
            onValueChange = {
                buyerMobile = it
            },
            label = { Text("موبایل خریدار") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .constrainAs(buyerMobileInput) {
                    top.linkTo(buyerFullNameInput.bottom, margin = 16.dp)
                    end.linkTo(parent.end)

                }
        )
        Button(onClick = {
            //navigate to InvoiceItemAddScreen
            
        },
            modifier = Modifier.constrainAs(btnAddProduct){
                top.linkTo(buyerMobileInput.bottom, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            Text("افزودن محصول")
        }
    }
}