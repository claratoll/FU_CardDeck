package com.example.carddeck


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlayActivity : AppCompatActivity() {

    private lateinit var cardText : TextView
    private lateinit var timeLeft : TextView

    private lateinit var largerButton : Button
    private lateinit var smallerButton : Button

    private lateinit var cardImageView: ImageView

    private var points: Int = 0

    private val deck = Deck
    private val player = Players



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        cardText = findViewById(R.id.currentCard)
        timeLeft = findViewById(R.id.livesLeft)

        largerButton = findViewById(R.id.largerButton)
        smallerButton = findViewById(R.id.smallerButton)

        cardImageView = findViewById(R.id.cardImageView)
        cardImageView.setImageResource(Deck.cards[0].picture)

        cardText.text = "you have $points points"


        largerButton.setOnClickListener {
            deck.drawCard()
            if (deck.currentCard.number > deck.nextCard.number){
                points++
                cardText.text = "you have $points points"
            } else {
                points--
            }
            cardImageView.setImageResource(deck.currentCard.picture)
        }

        smallerButton.setOnClickListener{
            deck.drawCard()
            if(deck.currentCard.number< deck.nextCard.number){
                points++
                cardText.text = "you have $points points"
            }else{
                points--
            }
            cardImageView.setImageResource(deck.currentCard.picture)
        }


        //timer
        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timeLeft.text = "seconds remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                startWinLostActivity(points)
            }
        }.start()
    }

    fun startWinLostActivity(result: Int) {
        val intent = Intent(this, WinLostActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}

