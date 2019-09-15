package sabacc

class Player(id: String, h: Hand, pP: Pot, bOut: Boolean) {
    /*
    Player must have a name, hand and a personal amount of money, and whether they are bombed out
     */
    var hand = h
    var playerPot = pP
    var bombOut = bOut
    var name = id

    /***
     * This function removes all cards from their hand (used in a fold or a new game round)
     * params: none
     * returns: none
     */
    fun emptyHand() {
        if (hand.cards.size > 0) {
            hand.cards.clear()
        }
    }

    /***
     * This function calculates the score of the current hand
     * params: none
     * returns: the num value of the players hand
     */
    fun score(): Int {
        var value = 0
        for (card in hand.cards){
            value += card.cardRank.cardValue
        }
        if (value > 23 || value < -23) {
            bombOut = true
            emptyHand()
            return -100
        }
        return value
    }

    /***
     * This function allows a player to add and remove from the Interference Field
     */
    fun moveToInterference() {
        //TODO: Interference only matters for shift which I will be implementing in the second phase
    }
}