package net.ragham.candidateassessment.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(navController: NavHostController,modifier: Modifier){
    NavHost(navController = navController, startDestination = Screen.InvoiceEditorScreen.route, modifier = modifier){
        composable(Screen.InvoiceEditorScreen.route) {
            //define composable screen
        }

        composable(Screen.InvoiceItemAddScreen.route){

        }

        composable(Screen.InvoicesScreen.route) {

        }
        composable(Screen.ProductsScreen.route) {

        }
    }
}