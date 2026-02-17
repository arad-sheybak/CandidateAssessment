package net.ragham.candidateassessment.navigation

sealed class Screen(val route:String){
    object InvoiceEditor :Screen("invoiceEditor")

    object InvoiceItemAdd:Screen("invoiceItemAdd")

    object Invoices: Screen("invoices")

    object Products: Screen("products")
}