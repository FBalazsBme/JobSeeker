package com.example.jobseeker.database

import com.example.jobseeker.network.swagger.client.model.Job

class Converter {

    fun RoomJob.toDomainModel(): Job {
        return Job(
            id,type,url, createdAt, company,
            companyUrl, location, title,
            description, howToApply, companyLogo
        )
    }

    fun Job.toRoomModel(): RoomJob {
        return RoomJob(
            id,type,url, createdAt, company,
            companyUrl, location, title,
            description, howToApply, companyLogo
        )
    }

}