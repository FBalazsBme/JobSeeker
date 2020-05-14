package com.example.jobseeker.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.jobseeker.database.JobRepository
import com.example.jobseeker.database.RoomJob


class JobViewModel(application: Application)  : AndroidViewModel(application){

    private var mRepository: JobRepository? = null

    private lateinit var jobsLive : LiveData<List<RoomJob>>

    private lateinit var jobs : List<RoomJob>

    fun getLiveAllJobs(): LiveData<List<RoomJob>> {
        return jobsLive
    }


    fun getAllJobs(): List<RoomJob> {
        return jobs
    }

    init {
        println("JobViewModel constructor")
        mRepository = JobRepository(application)
        jobs = mRepository!!.getAllJobs()
    }


}