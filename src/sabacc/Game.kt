package sabacc

class Game(){
    var deck = Deck()
    var sabaccPot: Pot = Pot(0)


    /***
     * This function uses Kotlin's built in shuffle method to shuffle the deck
     * params: deck a deck of the regulation 76 Sabacc Cards
     * returns: none
     */
    fun shuffleDeck() {
        deck.deckList.shuffle()
    }


    /***
     * This function takes one Card off the top of the Deck
     * params: none
     * returns:
     *
     */
    fun draw(): Card {
        return deck.deckList.removeAt(0)
    }

    /***
     * This function deals a hand for a player which is 2 Cards
     */
    fun deal(player: Player) {
        player.hand.addCard(deck.deckList.removeAt(0))

    }

    /***
     * This function performs the random shift in Cards in play 1-3 times in a game
     * params: none
     * returns: none
     */
    fun shift() {
        //TODO: Interference only matters for shift which I will be implementing in the second phase
    }

    /***
     * This function adds an indicated bet to the pot and updates the current round bet
     * params: amount the value of the initial bet
     * returns: none
     */
    fun bet(amount: Int, pot: Pot){
        pot.increasePot(amount)
    }

    /***
     * This function adds the current bet to the pot from the current player to match the current bet
     * params: none
     * returns: none
     */
    fun match() {
        //TODO: figure out if this needs a param or if I can do this without
    }

    /***
     * This function raises the current bet and adds to the pot from the current player
     * params: none
     * returns: none
     */
    fun raise() {
        //TODO: architect how betting takes place and if I actually need 3 methods for betting on the Game side
    }

    /***
     * This function removes a player from play and does not make any changes to their current funds
     * params: none
     * returns: none
     */
    fun fold(player: Player) {
        player.emptyHand()
    }

    /***
     * This function adds the initial ante to the Sabacc and Main Pot
     * params:
     *      amount the amount of the ante as described in the Game
     *      pot the current pot that needs to be anted
     * returns: none
     */
    fun ante(amount: Int, p: Pot) {
        p.increasePot(amount)
    }

    /***
     * This function removes a card from the list of cards able to shift
     * params: c the Card to be placed in the Interference Field
     * returns: none
     */
    fun addToInterference(c: Card) {
        //TODO: Interference only matters for shift which I will be implementing in the second phase
    }
}
