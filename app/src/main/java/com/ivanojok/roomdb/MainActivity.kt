package com.ivanojok.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ivanojok.roomdb.model.DBBuilder
import com.ivanojok.roomdb.model.StudentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    var list : List<StudentModel> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener {
            startActivity(Intent(this, EnterInformation::class.java))
        }

        val scope = CoroutineScope(Dispatchers.IO).launch {
            val dbBuilder = DBBuilder()
            val db = dbBuilder.createDB(this@MainActivity)
            val dao = db.studentDao()
            val students = dao.getAllStudents()
            Log.d("students", "$students")
            list = students

            withContext(Dispatchers.Main) {
                //call recycler view
            }
        }

        //call recycler

    }
}