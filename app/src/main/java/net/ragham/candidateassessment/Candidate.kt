package net.ragham.candidateassessment

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Candidate: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Candidate)
            //di -> appModules

        }
    }
}