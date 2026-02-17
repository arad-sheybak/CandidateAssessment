package net.ragham.candidateassessment.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.ragham.candidateassessment.ui.pages.invoiceEditor.InvoiceEditorScreen
import net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen.InvoiceItemAddScreen
import net.ragham.candidateassessment.ui.pages.invoices.InvoicesScreen
import net.ragham.candidateassessment.ui.pages.products.ProductsScreen

@Composable
fun AppNavHost(navController: NavHostController,modifier: Modifier){
    NavHost(navController = navController, startDestination = Screen.InvoiceEditor.route, modifier = modifier){
        composable(Screen.InvoiceEditor.route) {
            //define composable screen
            InvoiceEditorScreen()
        }

        composable(Screen.InvoiceItemAdd.route){
            InvoiceItemAddScreen()
        }

        composable(Screen.Invoices.route) {
            InvoicesScreen()
        }
        composable(Screen.Products.route) {
            ProductsScreen()
        }
    }
}