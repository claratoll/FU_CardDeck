package com.example.carddeck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class WinLostActivity : AppCompatActivity() {


    private lateinit var winLostText : TextView

    private lateinit var yesButton : ImageView
    private lateinit var noButton : ImageView
    private lateinit var leaderBoardButton : Button

    var playerPosition: Int = 0

    private var player: Player? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_lost)

        winLostText = findViewById(R.id.win_lost_textView)

        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)
        leaderBoardButton = findViewById(R.id.toLeaderBoardButton)


        playerPosition = intent.getIntExtra(PLAYER_POSITION_KEY, 0)


        player = Players.players[playerPosition]


        winLostText.text = "you got ${player!!.playerPoints.toString()} points"


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


    private fun toLeaderBoard(){

        val intent = Intent(this, LeaderBoardActivity::class.java)
        intent.putExtra(PLAYER_POSITION_KEY, playerPosition)
        startActivity(intent)
    }


    private fun playAgain(){
        val intent = Intent(this, PlayActivity::class.java)

        intent.putExtra(PLAYER_POSITION_KEY, playerPosition++)

        startActivity(intent)
    }

    private fun quitGame(){
        finishAffinity()
    }
}