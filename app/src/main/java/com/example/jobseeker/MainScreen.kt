package com.example.jobseeker

interface MainScreen {
    fun listJobs(jobKeyWord: String, jobLocation: String)

    fun showJobDetail()
}