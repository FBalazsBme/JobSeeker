package com.example.jobseeker.database

import androidx.room.TypeConverter
import com.example.jobseeker.network.swagger.client.model.Job
import java.util.*


class Converter {

/*    @TypeConverter
    fun RoomJob.toDomainModel(): Job {
        return Job(
            id,type,url, createdAt, company,
            companyUrl, location, title,
            description, howToApply, companyLogo
        )
    }

    @TypeConverter
    fun Job.toRoomModel(): RoomJob {
        return RoomJob(
            id,type,url, createdAt, company,
            companyUrl, location, title,
            description, howToApply, companyLogo
        )
    }*/

    @TypeConverter
    fun toLong(date : Date ): Long? {
        if (date == null) return null else { return date.getTime()}
    }

    @TypeConverter
    fun toDate(date : Long ): Date? {
        if (date == null) return null else { return Date(date)}
    }

}