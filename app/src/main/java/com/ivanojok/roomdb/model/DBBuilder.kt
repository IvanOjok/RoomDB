package com.ivanojok.roomdb.model

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class DBBuilder {

    //val db = RoomDatabase.Builder()

    fun createDB(context: Context): StudentDatabase {
        val db = Room.databaseBuilder(context, StudentDatabase::class.java, "roomDB")
            .fallbackToDestructiveMigration()
            .build()
        return db
    }


}