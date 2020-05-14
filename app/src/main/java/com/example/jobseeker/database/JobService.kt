package com.example.jobseeker.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JobService {

    @Query("SELECT * FROM roomjob")
    fun getLiveAllJobs(): LiveData<List<RoomJob>>

    @Query("SELECT * FROM roomjob")
    fun getAllJobs(): List<RoomJob>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addJob(job: RoomJob)
}