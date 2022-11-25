package com.example.carddeck


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlayActivity : AppCompatActivity() {

    private lateinit var cardText : TextView
    private lateinit var livesLeft : TextView

    private lateinit var largerButton : Button
    private lateinit var smallerButton : Button

    private lateinit var cardImageView: ImageView

    private var points: Int = 0
    private var lives: Int = 5

    private val deck = Deck


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        cardText = findViewById(R.id.currentCard)
        // = findViewById(R.id.livesLeft)

        largerButton = findViewById(R.id.largerButton)
        smallerButton = findViewById(R.id.smallerButton)

        cardImageView = findViewById(R.id.cardImageView)
        cardImageView.setImageResource(Deck.cards[0].picture)

        cardText.text = "you have $points points"
        //livesLeft.text = "you have $lives lives left"


        largerButton.setOnClickListener {
            deck.drawCard()
            if (deck.currentCard.number > deck.nextCard.number){
                points++
                cardText.text = "you have $points points"
                if (points == 10){
                    startWinLostActivity(true)
                }
            } else {
                lives --
                //livesLeft.text = "you have $lives lives left"
                if (lives == 0){
                    startWinLostActivity(false)
                }
            }
            cardImageView.setImageResource(deck.currentCard.picture)
        }

        smallerButton.setOnClickListener{
            deck.drawCard()
            if(deck.currentCard.number< deck.nextCard.number){
                points++
                cardText.text = "you have $points points"
                if (points == 10){
                    startWinLostActivity(true)
                }
            }else{
                lives--
               // livesLeft.text = "you have $lives lives left"
                if (lives==0){
                    startWinLostActivity(false)
                }
            }
            cardImageView.setImageResource(deck.currentCard.picture)
        }
    }

    fun startWinLostActivity(result: Boolean) {
        val intent = Intent(this, WinLostActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}

