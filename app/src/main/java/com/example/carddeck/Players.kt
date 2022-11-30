package com.example.carddeck

object Players {
    val players = mutableListOf<Player>()


    init {
        createPlayers()
    }

    fun createPlayers(){
        players.add(Player("Clara", 1, 4))
        players.add(Player("Super winner", 2, 45))
        players.add(Player("Alice", 3, 8))
        players.add(Player("Rocky", 4, 21))

    }
}