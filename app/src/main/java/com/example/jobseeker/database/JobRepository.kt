package com.example.jobseeker.database

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData

class JobRepository(application : Application) {


    lateinit var jobsLive : LiveData<List<RoomJob>>
    lateinit var jobs : List<RoomJob>
    var ready = false;
    var jobsReceived : List<RoomJob> = listOf()

    init {
        ready = false;
        println("initrepo started!")
        val roomJobDatabase = RoomJobDatabase.getInstance(application)
        jobs = roomJobDatabase.roomJobDao().getAllJobs()
        println("repo is ready!")
        ready = true;
    }

    fun getAllJobs(): List<RoomJob> {
            return jobs
    }



}