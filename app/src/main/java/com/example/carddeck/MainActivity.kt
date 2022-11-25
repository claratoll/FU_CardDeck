package com.example.carddeck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button_start)
        val createPlayerButton = findViewById<Button>(R.id.addPlayerButton)

        button.setOnClickListener{
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }

        createPlayerButton.setOnClickListener {
            val intent = Intent(this, CreateAndEditPlayerActivity::class.java)
            startActivity(intent)
        }


    }
}