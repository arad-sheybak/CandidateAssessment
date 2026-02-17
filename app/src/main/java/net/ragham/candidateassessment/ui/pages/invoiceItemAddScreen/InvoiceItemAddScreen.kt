package net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InvoiceItemAddScreen() {
    InvoiceItemAddUi()
}

@Composable
@Preview
private fun InvoiceItemAddUi() {
    var productName by remember { mutableStateOf("") }
    var productUnitPrice by remember { mutableStateOf("") }
    var productUnit by remember { mutableStateOf("") }
    var productDiscountAmount by remember { mutableStateOf("") }
    var productDiscountPercent by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = productName,
            onValueChange = {
                productName = it
            },
            label = {
                Text("نام محصول")
            }
        )

        OutlinedTextField(
            value = productUnitPrice,
            onValueChange = {
                productUnitPrice = it
            },
            label = {
                Text("مبلغ واحد محصول")
            }
        )
        OutlinedTextField(
            value = productUnit,
            onValueChange = {
                productUnit = it
            },
            label = {
                Text("واحد")
            }
        )

        OutlinedTextField(
            value = productDiscountAmount,
            onValueChange = {
                productDiscountAmount = it
            },
            label = {
                Text("مبلغ تخفیف")
            }
        )

        OutlinedTextField(
            value = productDiscountAmount,
            onValueChange = {
                productDiscountAmount = it
            },
            label = {
                Text("درصد تخفیف")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            //navigate to InvoiceEditor
        }) {
            Text("ثبت محصول")
        }
    }
}