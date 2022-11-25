package com.example.carddeck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class WinLostActivity : AppCompatActivity() {


    private lateinit var winLostText : TextView

    private lateinit var yesButton : ImageView
    private lateinit var noButton : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_lost)

        winLostText = findViewById(R.id.win_lost_textView)

        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)

        var bool = false
        bool = intent.getBooleanExtra("result", bool)


        if (bool){
            winLostText.text = "You won!"
        } else {
            winLostText.text = "You lost!"
        }

        yesButton.setOnClickListener {
            playAgain()
        }

        noButton.setOnClickListener {
            quitGame()
        }
    }


    fun win (){

    }

    fun lost() {

    }


    private fun playAgain(){

        //i think this starts a new activity and dont delete the old info :/
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
     //   finish()
    }

    private fun quitGame(){
        finishAffinity()
    }
}