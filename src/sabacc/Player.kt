package sabacc

class Player(h: Hand, pP: Pot) {
    /*
    Player must have a hand and a personal amount of money
     */
    var hand = h
    var playerPot = pP

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
     * This function allows a player to add and remove from the Interference Field
     */
    fun moveToInterference() {
        //TODO: Interference only matters for shift which I will be implementing in the second phase
    }
}