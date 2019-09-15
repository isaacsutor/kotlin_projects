package sabacc

import java.util.ArrayList

fun main(args: Array<String>) {
    val currentGame = Game()

    val initHand = Hand(arrayListOf(Card(Suit.SABERS, Rank.ONE)))
    val players = arrayListOf<Player>()
    for (numPlayers in 0..3) {
        val player = Player("Player One", initHand, Pot(1000), false)
        player.emptyHand()
        players.add(player)
    }

    // make the pots/set up game play, ante and get players initial hands
    var sabaccPot = Pot(0)
    var mainPot = Pot(0)

    // loop through each player to remove any players not playing this round
    for (numPlayers in 0..3) {
        val pName = players[numPlayers].name
        print("$pName: Do you want to ante? (Y/N")
        val stringInput = readLine()!!

        if (stringInput.toLowerCase() == "y") {
            currentGame.deal(players[numPlayers])
        }
    }

    // start rounds for betting || check each card change for bombOut

    // check scores

    // if tie, complete Sudden Demise

    // if exact 23 or -23 award SabaccPot and MainPot

    // otherwise award mainPot



}