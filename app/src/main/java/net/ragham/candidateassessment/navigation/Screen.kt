package net.ragham.candidateassessment.navigation

sealed class Screen(val route:String){
    object InvoiceEditorScreen :Screen("invoiceEditor")

    object InvoiceItemAddScreen:Screen("invoiceItemAdd")

    object InvoicesScreen: Screen("invoices")

    object ProductsScreen: Screen("products")
}