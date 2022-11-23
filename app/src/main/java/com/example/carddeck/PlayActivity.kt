package com.example.carddeck


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class PlayActivity : AppCompatActivity() {

    private lateinit var cardText : TextView
    private lateinit var largerButton : Button
    private lateinit var smallerButton : Button

    private lateinit var cardImageView: ImageView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)



        cardText = findViewById(R.id.currentCard)
        largerButton = findViewById(R.id.largerButton)
        smallerButton = findViewById(R.id.smallerButton)
        cardImageView = findViewById(R.id.cardImageView)


        val position = 1
       // lateinit var currentCard
        //lateinit var nextCard

//        createCard()

        largerButton.setOnClickListener {
            checkIfNextCardIsLargerOrSmaller()
            DataManager.cards[position].name = cardText.text.toString()

        }
        smallerButton.setOnClickListener{
            checkIfNextCardIsLargerOrSmaller()

        }
    }



    fun randomNextCard(): Int {
        return (1..13).random()
    }

    private fun checkIfNextCardIsLargerOrSmaller(): Boolean {
        
        val currentCard = DataManager.createMockData()

        cardImageView.setImageResource(currentCard)



        var points = 0
        val randomCardNumber = randomNextCard()
        val nextValue = 14


                if (nextValue > randomCardNumber){
                    points++
                } else {
                    //loose
                }

                //  val nextValue : Int = DataManager.cards.size


                if (nextValue < randomCardNumber){
                    points++
                } else {
                    //loose
                }

return true
    }

}
