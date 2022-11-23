package com.example.carddeck


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlayActivity : AppCompatActivity() {

    private lateinit var cardText : TextView
    private lateinit var showAnswer : TextView

    private lateinit var largerButton : Button
    private lateinit var smallerButton : Button

    private lateinit var cardImageView: ImageView

    private var points: Int = 0

    val deck = Deck

    //   private lateinit var recyclerView: RecyclerView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)


        /*recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CardsRecyclerAdapter(this, DataManager.cards)
*/


        cardText = findViewById(R.id.currentCard)
        showAnswer = findViewById(R.id.larger_smaller)

        largerButton = findViewById(R.id.largerButton)
        smallerButton = findViewById(R.id.smallerButton)

        cardImageView = findViewById(R.id.cardImageView)

        val currentCard = Deck.cards
        val position = 1
       // lateinit var currentCard
        //lateinit var nextCard

//        createCard()

        val smaller = 1
        val larger = 2

        largerButton.setOnClickListener {

            checkIfNextCardIsLargerOrSmaller(larger)

        }
        smallerButton.setOnClickListener{

            checkIfNextCardIsLargerOrSmaller(smaller)

        }
    }

    fun randomNextCard(): Int { return (1..13).random() }



    private fun checkIfNextCardIsLargerOrSmaller(number: Int) {
        


        val randomCardNumber = randomNextCard()
        val nextValue = 4

        if (number == 1){
            if (nextValue < randomCardNumber){
                points++
            } else {
                //loose
            }
        } else if (number == 2){

            if (nextValue > randomCardNumber){
                points++
            } else {
                //loose
            }

        }


        cardText.text = points.toString()

        //fixa så den hämtar alla kort istället
        cardImageView.setImageResource(Deck.cards[randomCardNumber].picture)

        showAnswer.text = randomCardNumber.toString()

    }

}
