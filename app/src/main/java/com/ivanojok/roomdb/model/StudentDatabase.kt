package com.ivanojok.roomdb.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentModel::class], version = 2)
abstract class StudentDatabase: RoomDatabase() {
    abstract fun studentDao():StudentDao
}