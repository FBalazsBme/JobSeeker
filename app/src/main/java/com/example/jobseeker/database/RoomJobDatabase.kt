package com.example.jobseeker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

private const val DATABASE = "notes"

@Database(
    entities = [RoomJob::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class RoomJobDatabase : RoomDatabase() {

    abstract fun roomJobDao(): JobService

    //code below courtesy of https://github.com/googlesamples/android-sunflower; it     is open
    //source just like this application.
    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: RoomJobDatabase? = null

        fun getInstance(context: Context): RoomJobDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): RoomJobDatabase {
            return Room.databaseBuilder(context, RoomJobDatabase::class.java, DATABASE)
                .build()
        }
    }
}