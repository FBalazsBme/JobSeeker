package com.example.jobseeker.ui.main

interface MainScreen {
    fun listJobs(jobKeyWord: String, jobLocation: String)

    fun showJobDetail()
}