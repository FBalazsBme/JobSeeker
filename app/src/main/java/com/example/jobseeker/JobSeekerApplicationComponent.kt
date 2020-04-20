package com.example.jobseeker

import com.example.jobseeker.ui.UIModule
import com.example.jobseeker.ui.main.MainActivity
import com.example.jobseeker.ui.main.ResultListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class])
interface JobSeekerApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(resultList: ResultListActivity)
}
