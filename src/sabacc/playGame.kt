package sabacc

import java.util.ArrayList

/***
 * This function is the betting round part of game play where players may bet, raise, match, and fold
 * params:
 *          nPlayers: int that is the number of players still in the game
 *          players: ArrayList of Players still in the game
 *          currentGame: the Game at play
 */
fun bettingRound(numberPlayersInRound: Int, players: ArrayList<Player>, currentGame: Game) {
    // start rounds for betting || check each card change for bombOut
    // let each player bet
    for (initBetPlayer in 0..numberPlayersInRound) {
        // set bet
        var bet = 0
        val currentPlayerNameForStartBet = players[initBetPlayer].name
        print("$currentPlayerNameForStartBet would you like to place a bet: ")
        val placeBetBool = readLine()!!
        if (placeBetBool.toLowerCase() == "y") {
            print("How much would you like to bet: ")
            val betAmount = readLine()!!
            val bet = betAmount.toInt()
        }
        // let players match, raise, or fold
        for (reactPlayer in 0..numberPlayersInRound) {
            if (reactPlayer == initBetPlayer) {

            }
            else {
                val currentPlayerName = players[reactPlayer].name
                var validInput = true
                // loop through if no valid input || may do more complex validation later
                while (validInput) {
                    print("$currentPlayerName would you like to RAISE, MATCH, or FOLD: ")
                    val playerMoveInput = readLine()!!
                    if (playerMoveInput.toLowerCase() == "raise") {
                        print("How much would you like to raise: ")
                        val stringInput = readLine()!!
                        val bet = stringInput.toInt()
                    }
                    else if (playerMoveInput.toLowerCase() == "match") {
                        // maybe add player bet in data class
                        break
                    }
                    else if (playerMoveInput.toLowerCase() == "fold") {
                        //TODO: implement fold to remove player from list of active players
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

/***
 * This Function allows for each player to "Call", stopping the betting round if there is enough call votes
 * params: none
 * return: none
 */
fun callingRound() {
    //TODO: Implement calling round features as described in rules.txt
}


fun main() {
    val currentGame = Game()

    // SET UP PHASE
    // set up number of players at the table
    print("Please Enter Number of Players at Table:  ")
    val stringInput = readLine()!!
    val numberOfPlayersAtTable = stringInput.toInt() - 1

    // Add players with player input name based on response
    val listOfPlayers = arrayListOf<Player>()
    val initHand = Hand(arrayListOf(Card(Suit.SABERS, Rank.ONE)))
    for (numPlayers in 0..numberOfPlayersAtTable) {
        // get player name
        print("Please Enter Your Name:  ")
        val playerNameFromInput = readLine()!!

        // get player bank amount
        print("$playerNameFromInput please enter your starting bank account and pay the house: ")
        val playerPotValFromInput = readLine()!!
        val playerPotVal = playerPotValFromInput.toInt()

        // create player and add them to the array of players
        val player = Player(playerNameFromInput, initHand, Pot(playerPotVal), false)
        player.emptyHand()
        listOfPlayers.add(player)
    }

    // make the pots/set up game play, ante and get players initial hands
    var sabaccPot = Pot(0)
    var mainPot = Pot(0)

    // loop through each player to remove any players not playing this round
    for (numPlayers in 0..numberOfPlayersAtTable) {
        val currentPlayerName = listOfPlayers[numPlayers].name
        print("$currentPlayerName: Do you want to ante? (Y/N) ")
        val playerAnteBool = readLine()!!

        if (playerAnteBool.toLowerCase() == "y") {
            currentGame.deal(listOfPlayers[numPlayers])
        }
        else {
            // bombOut = true will remove the player from gameplay so its the same as if they aren't playing
            listOfPlayers[numPlayers].bombOut = true
        }
    }
    var called = false
    var round = 0
    while (!called) {
        // PLAYING (DRAWING) ROUND


        // BETTING ROUND



        // SHIFTING ROUND: IMPLEMENT LATER (waiting on interference field for regular gameplay)



        if (round >= 4) {
            // CALLING ROUND
            called = true
        }
        round++
    }

    // DETERMINE WINNER
    // check scores compare to -23 or 23. Ties for distance broken by pos win.
    //var maxScore = -100
    for (person in 0..numberOfPlayersAtTable) {

    }
    // if tie, complete Sudden Demise

    // if exact 23 or -23 award SabaccPot and MainPot

    // otherwise award mainPot



}