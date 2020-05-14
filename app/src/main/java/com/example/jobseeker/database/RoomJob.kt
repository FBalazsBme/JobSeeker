package com.example.jobseeker.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*



@Entity(tableName = "roomjob")
class RoomJob (
    @PrimaryKey
    val id: String,

    val type: String,

    val url: String,

    val createdAt: Date,

    val company: String,

    val companyUrl: String,

    val location: String,

    val title: String,

    val description: String,

    val howToApply: String
)