package com.example.carddeck


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
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

    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CardsRecyclerAdapter(this, DataManager.cards)

        /*cardText = findViewById(R.id.currentCard)
        largerButton = findViewById(R.id.largerButton)
        smallerButton = findViewById(R.id.smallerButton)
        cardImageView = findViewById(R.id.cardImageholder)

*/
        val position = 1
       // lateinit var currentCard
        //lateinit var nextCard

//        createCard()

     /*   largerButton.setOnClickListener {
            checkIfNextCardIsLargerOrSmaller()
            DataManager.cards[position].name = cardText.text.toString()

        }
        smallerButton.setOnClickListener{
            checkIfNextCardIsLargerOrSmaller()

        }*/
    }

    private fun checkIfNextCardIsLargerOrSmaller(): Boolean {

        val currentCard = createCard()
        cardImageView.setImageResource(currentCard)
        val nextCard = createCard()

        if (currentCard > nextCard){
            return true
        } else if (currentCard < nextCard ){
            return false
        } else {
            return false
        }


    }



    private fun createCard(): Int {
        val random = Random
        val imageInt = random.nextInt(DataManager.cards.size)
        val image = DataManager.cards.size

        cardText.text = imageInt.toString()


       // imageView.setImageResource(image)
        return image

    }

   /* override fun onResume() {
        super.onResume()

        recyclerView.adapter?.notifyDataSetChanged()
    }*/

}