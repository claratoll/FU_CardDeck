package com.example.carddeck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


const val PLAYER_POSITION_KEY = "PLAYER_POSITION"
const val POSITION_NOT_SET = 0


class CreateAndEditPlayerActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText

    var playerPosition: Int = 0
    private var player: Player? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_edit_player)

        nameEditText = findViewById(R.id.playerNameEditText)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val startPlayingButton = findViewById<Button>(R.id.startPlaying)


        playerPosition = intent.getIntExtra(PLAYER_POSITION_KEY, playerPosition)


        if (playerPosition != POSITION_NOT_SET){
            displayPlayer()
            saveButton.setOnClickListener {
                editPlayer()
            }
        } else {
            saveButton.setOnClickListener {
                addNewPlayer()
            }
        }

        startPlayingButton.setOnClickListener{
            val intent = Intent(this, PlayActivity::class.java)
            intent.putExtra(PLAYER_POSITION_KEY, playerPosition)
            startActivity(intent)
        }


    }

    fun displayPlayer () {
        player = Players.players[playerPosition]

        nameEditText.setText(player!!.playerName)
    }

    fun addNewPlayer(){
        val name = nameEditText.text.toString()

        val player = Player(name, 0)

        Players.players.add(player)
        finish()
    }


    fun editPlayer(){
        Players.players[playerPosition].playerName = nameEditText.text.toString()
        finish()
    }
}