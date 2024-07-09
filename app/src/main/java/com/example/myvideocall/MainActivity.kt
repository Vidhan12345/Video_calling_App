package com.example.myvideocall

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.join)
        val name = findViewById<EditText>(R.id.name)

        btn.setOnClickListener {
            val intent = Intent(this@MainActivity, CallingPage::class.java)
            intent.putExtra("name", name.text.toString())
            startActivity(
                intent
            )
        }

    }

}