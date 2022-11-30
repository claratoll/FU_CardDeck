package com.example.carddeck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val PLAYER_POSITION_KEY = "PLAYER_POSITION"
const val POSITION_NOT_SET = -1


class CreateAndEditPlayerActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var playerPointsTextView: TextView

    lateinit var saveButton: Button
    lateinit var startPlayingButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_edit_player)

        nameEditText = findViewById(R.id.playerNameText)
        playerPointsTextView = findViewById(R.id.pointsTextView)

        saveButton = findViewById(R.id.saveButton)
        startPlayingButton = findViewById(R.id.startPlaying)

        val playerPosition = intent.getIntExtra(PLAYER_POSITION_KEY, POSITION_NOT_SET)


        if (playerPosition != POSITION_NOT_SET){
            displayPlayer(playerPosition)
            saveButton.setOnClickListener {
                editPlayer(playerPosition)
            }
        } else {
            saveButton.setOnClickListener {
                addNewPlayer(playerPosition)
            }
        }

        startPlayingButton.setOnClickListener{

        }


    }

    fun displayPlayer (position : Int) {
        val player = Players.players[position]

        nameEditText.setText(player.playerName)
        playerPointsTextView.setText(player.playerPoints)
    }

    fun addNewPlayer(position: Int){
        val name = nameEditText.text.toString()

        val newPosition = position +1

        val player = Player(name, newPosition, 0)
        Players.players.add(player)
    }


    fun editPlayer(position: Int){
        Players.players[position].playerName = nameEditText.text.toString()

        finish()
    }
}