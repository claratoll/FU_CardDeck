package com.example.carddeck

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayersRecyclerAdapter (val context : Context, val players : List <Player>) : RecyclerView.Adapter<PlayersRecyclerAdapter.ViewHolder>() {


    val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = players[position]

        holder.playerNumberTextView.text = player.playerNumber.toString()
        holder.playerNameTextView.text = player.playerName
        holder.pointsTextView.text = player.playerPoints.toString()

        holder.playerPosition = position

    }

    override fun getItemCount() = players.size


    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        val playerNumberTextView = itemView.findViewById<TextView>(R.id.number_player_textView)
        val playerNameTextView = itemView.findViewById<TextView>(R.id.name_textView)
        val pointsTextView = itemView.findViewById<TextView>(R.id.pointsTextView)
        val editButton = itemView.findViewById<ImageButton>(R.id.edit_button)
        var playerPosition = 0

        init {
            editButton.setOnClickListener{
                val intent = Intent(context, CreateAndEditPlayerActivity::class.java)
                intent.putExtra(PLAYER_POSITION_KEY, playerPosition)
                context.startActivity(intent)
            }
        }

    }
}