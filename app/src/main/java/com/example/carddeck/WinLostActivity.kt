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
    private lateinit var leaderBoardButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_lost)

        winLostText = findViewById(R.id.win_lost_textView)

        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)
        leaderBoardButton = findViewById(R.id.toLeaderBoardButton)

        val playerPosition = intent.getIntExtra(PLAYER_POSITION_KEY, POSITION_NOT_SET)

        val player = Players.players[playerPosition]


        winLostText.text = "you got ${player.playerPoints.toString()} points"


        yesButton.setOnClickListener {
            playAgain()
        }

        noButton.setOnClickListener {
            quitGame()
        }

        leaderBoardButton.setOnClickListener {
            toLeaderBoard()
        }
    }


    fun win (){

    }

    fun lost() {

    }

    private fun toLeaderBoard(){

        val intent = Intent(this, LeaderBoardActivity::class.java)
        startActivity(intent)
    }


    private fun playAgain(){
        //i think this starts a new activity and dont delete the old info :/
        val intent = Intent(this, PlayActivity::class.java)
        startActivity(intent)
    }

    private fun quitGame(){
        finishAffinity()
    }
}