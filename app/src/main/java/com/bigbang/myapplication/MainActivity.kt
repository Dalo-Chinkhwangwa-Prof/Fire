package com.bigbang.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = Student("Dalo", 100)

        FirebaseDatabase.getInstance()
            .reference.child("STUDENTS")
            .push().setValue(student)

        FirebaseDatabase.getInstance()
            .reference.child("STUDENTS")
            .addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    //This this is were an error has occurred
                }

                override fun onDataChange(data: DataSnapshot) {

                    var string = ""
                    data.children.forEach { snap ->

                        snap.getValue(Student::class.java)?.let { student ->

                            string += "${student.name}\n"
                        }
                    }

                    textview.text = string
                }

            })

    }
}