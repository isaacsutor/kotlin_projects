package sabacc

import java.util.ArrayList

/***
 * This function is the betting round part of game play where players may bet, raise, match, and fold
 * params:
 *          nPlayers: int that is the number of players still in the game
 *          players: ArrayList of Players still in the game
 *          currentGame: the Game at play
 */
fun bettingRound(nPlayers: Int, players: ArrayList<Player>, currentGame: Game) {
    // start rounds for betting || check each card change for bombOut
    // let each player bet
    for (numPlayer in 0..nPlayers) {
        // set bet
        var bet = 0
        val pName = players[numPlayer].name
        print("$pName would you like to place a bet: ")
        val stringInput = readLine()!!
        if (stringInput.toLowerCase() == "y") {
            print("How much would you like to bet: ")
            val stringInput = readLine()!!
            val bet = stringInput.toInt()
        }
        // let players match, raise, or fold
        for (numPlayers in 0..nPlayers) {
            if (numPlayers == numPlayer) {

            }
            else {
                val pName = players[numPlayers].name
                var validInput = true
                // loop through if no valid input || may do more complex validation later
                while (validInput) {
                    print("$pName would you like to RAISE, MATCH, or FOLD: ")
                    val stringInput = readLine()!!
                    if (stringInput.toLowerCase() == "raise") {
                        print("How much would you like to raise: ")
                        val stringInput = readLine()!!
                        val bet = stringInput.toInt()
                    }
                    else if (stringInput.toLowerCase() == "match") {
                        // maybe add player bet in data class
                        break
                    }
                    else if (stringInput.toLowerCase() == "fold") {
                        currentGame.fold(players[numPlayers])
                        val stringInput = readLine()!!
                        val bet = stringInput.toInt()
                    }
                    else {
                        validInput = false
                    }
                }
            }
        }
    }
}

/***
 * This function is the drawing round part of game play where players may draw, do nothing, or exchange beware bombOut
 * params:
 *          nPlayers: int that is the number of players still in the game
 *          players: ArrayList of Players still in the game
 *          currentGame: the Game at play
 */
fun drawingRound(nPlayers: Int, players: ArrayList<Player>, currentGame: Game) {
    for (numPlayer in 0..nPlayers) {

    }
}

fun callingRound() {

}


fun main() {
    val currentGame = Game()

    // SET UP PHASE
    // set up number of players at the table
    print("Please Enter Number of Players at Table:  ")
    val stringInput = readLine()!!
    val nPlayers = stringInput.toInt() - 1

    // Add players with player input name based on response
    val players = arrayListOf<Player>()
    val initHand = Hand(arrayListOf(Card(Suit.SABERS, Rank.ONE)))
    for (numPlayers in 0..nPlayers) {
        // get player name
        print("Please Enter Your Name:  ")
        val stringInput = readLine()!!

        // get player bank amount
        print("$stringInput please enter your starting bank account and pay the house: ")
        val stringInput2 = readLine()!!
        val playerPotVal = stringInput2.toInt()

        // create player and add them to the array of players
        val player = Player(stringInput, initHand, Pot(playerPotVal), false)
        player.emptyHand()
        players.add(player)
    }

    // make the pots/set up game play, ante and get players initial hands
    var sabaccPot = Pot(0)
    var mainPot = Pot(0)

    // loop through each player to remove any players not playing this round
    for (numPlayers in 0..nPlayers) {
        val pName = players[numPlayers].name
        print("$pName: Do you want to ante? (Y/N) ")
        val stringInput = readLine()!!

        if (stringInput.toLowerCase() == "y") {
            currentGame.deal(players[numPlayers])
        }
        else {
            // bombOut = true will remove the player from gameplay so its the same as if they aren't playing
            players[numPlayers].bombOut = true
        }
    }
    var called = false
    var round = 0
    while (!called) {
        // PLAYING (DRAWING) ROUND


        // BETTING ROUND



        // SHIFTING ROUND: IMPLEMENT LATER



        if (round >= 4) {
            // CALLING ROUND
            called = true
        }
        round++
    }

    // DETERMINE WINNER
    // check scores compare to -23 or 23. Ties for distance broken by pos win.
    //var maxScore = -100
    for (person in 0..nPlayers) {

    }
    // if tie, complete Sudden Demise

    // if exact 23 or -23 award SabaccPot and MainPot

    // otherwise award mainPot



}