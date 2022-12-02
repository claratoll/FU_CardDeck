package com.example.carddeck

object Players {
    val players = mutableListOf<Player>()

    init {
        createPlayers()
        players.sortByDescending {
            it.playerPoints
        }
    }

    fun createPlayers(){
        players.add(Player("Clara", 4))
        players.add(Player("Super winner", 45))
        players.add(Player("Alice",  8))
        players.add(Player("Rocky", 21))
    }
}