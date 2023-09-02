package com.ivanojok.roomdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity  //(tableName = "studentTable")
data class StudentModel(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    val studentName:String,
    val studentAge:String,
    val studentId:String
)
