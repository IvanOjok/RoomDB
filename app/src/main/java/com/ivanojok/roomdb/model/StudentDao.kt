package com.ivanojok.roomdb.model

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(studentModel: StudentModel)

    @Query("Select * from studentmodel")
    fun getAllStudents(): List<StudentModel>

}
