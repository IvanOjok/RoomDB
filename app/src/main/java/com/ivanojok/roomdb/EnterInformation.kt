package com.ivanojok.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ivanojok.roomdb.model.DBBuilder
import com.ivanojok.roomdb.model.StudentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class EnterInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_information)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val studentName = findViewById<EditText>(R.id.student_name).text.toString()
            val studentAge = findViewById<EditText>(R.id.student_age).text.toString()
            val studentId = findViewById<EditText>(R.id.student_id).text.toString()

            val scope = CoroutineScope(Dispatchers.IO).launch {
                /** Created a database builder */
                val dbBuilder = DBBuilder()
                /** Created a database */
                val db = dbBuilder.createDB(this@EnterInformation)
                /** Created a dao */
                val dao = db.studentDao()
                /** Make queries */
                val student = StudentModel(id= null, studentName = studentName, studentId = studentId, studentAge= studentAge, )
                val query = dao.insertStudent(student)
            }
        }






    }
}