package com.example.carddeck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class PlayActivity : AppCompatActivity() {

    private lateinit var cardText : TextView
    private lateinit var timeLeft : TextView

    private lateinit var largerButton : Button
    private lateinit var smallerButton : Button

    private lateinit var cardImageView: ImageView

    private val deck = Deck

    var playerPosition: Int = 0

    private var player: Player? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        cardText = findViewById(R.id.currentCard)
        timeLeft = findViewById(R.id.livesLeft)

        largerButton = findViewById(R.id.largerButton)
        smallerButton = findViewById(R.id.smallerButton)

        cardImageView = findViewById(R.id.cardImageView)
        cardImageView.setImageResource(Deck.cards[0].picture)


        playerPosition = intent.getIntExtra(PLAYER_POSITION_KEY, 0)


        player = Player("new player", 0)
        Players.players.add(player!!)

        playerPosition = Players.players.size -1


        largerButton.setOnClickListener {
            deck.drawCard()
            if (deck.currentCard.number > deck.nextCard.number){
                player!!.playerPoints++
            } else {
                player!!.playerPoints--
            }
            cardImageView.setImageResource(deck.currentCard.picture)
            cardText.text = "you have ${player!!.playerPoints} points"
        }

        smallerButton.setOnClickListener{
            deck.drawCard()
            if(deck.currentCard.number< deck.nextCard.number){
                player!!.playerPoints++
            } else {
                player!!.playerPoints--
            }
            cardImageView.setImageResource(deck.currentCard.picture)
            cardText.text = "you have ${player!!.playerPoints} points"
        }

        //timer
        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timeLeft.text = "seconds remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                startWinLostActivity()
            }
        }.start()
    }

    fun startWinLostActivity() {

        val intent = Intent(this, WinLostActivity::class.java)
        intent.putExtra(PLAYER_POSITION_KEY, playerPosition)
        startActivity(intent)

    }
}

