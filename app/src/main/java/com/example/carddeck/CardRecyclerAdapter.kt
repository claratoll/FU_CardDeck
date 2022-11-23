package com.example.carddeck

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView



class CardsRecyclerAdapter (val context : Context, val cards : List <Card>) : RecyclerView.Adapter<CardsRecyclerAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.show_card, parent, false)

        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]

       // holder.imageView.setImageResource(card.picture)


    }

    override fun getItemCount() = cards.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val largerButton = itemView.findViewById<Button>(R.id.largerButton)
        val smallerButton = itemView.findViewById<Button>(R.id.smallerButton)




        init {
            largerButton.setOnClickListener {

                val nextValue : Int = DataManager.cards.size
            }



            /*
            val currentCard = createCard()
            cardImageView.setImageResource(currentCard)
            val nextCard = createCard()

            if (currentCard > nextCard){
                return true
            } else if (currentCard < nextCard ){
                return false
            } else {
                return false
            }*/


            /*     buyButton.setOnClickListener {
                DataManager.cards[buyPosition].buy = buyButton.isChecked
            }*/


        }

    }


}