package net.ragham.candidateassessment.di

import net.ragham.candidateassessment.ui.pages.invoiceEditor.InvoiceEditorViewModel
import net.ragham.candidateassessment.ui.pages.invoiceItemAddScreen.InvoiceItemAddViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel{
        InvoiceEditorViewModel()
    }
    viewModel{
        InvoiceItemAddViewModel()
    }
}