package com.example.jobseeker

import android.app.Application
import com.example.jobseeker.ui.UIModule

class JobSeekerApplication : Application() {
    lateinit var injector: JobSeekerApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerJobSeekerApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
