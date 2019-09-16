package sabacc

import java.util.ArrayList
import kotlin.Comparable

class Hand(hand: ArrayList<Card>): Comparable<Hand> {
    /*
    Hand contains a collection of Cards and will be held in the Player class
     */
    var cards = hand
    var score = 0

    /***
     * This function calculates the score of the hand
     * params: none
     * return: score as an Int
     */
    fun scoreHand(): Int {
        var value = 0
        for (card in cards){
            value += card.cardRank.cardValue
        }
        score = value
        return value
    }

    /***
     * This function adds cards to the hand
     * params: c card to add
     * returns: none
     */
    fun addCard(c: Card) {
        cards.add(c)
        scoreHand()
    }

    /***
     * This function removes a card from the hand
     * params: c card to remove
     * returns: none
     */
    fun removeCard(c: Card) {
        cards.remove(c)
    }

    /***
     * This function overrides the compareTo function to compare hand scores (tie broken by neg/pos)
     * params: other which is the Hand to compare to
     * returns: Int of -1, 0, or 1 for less than equal or greater than
     */
    override fun compareTo(other: Hand) = when {
        score < other.score -> -1
        score > other.score -> 1
        else -> 0
    }

}