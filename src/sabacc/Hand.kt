package sabacc

import java.util.ArrayList

class Hand(hand: ArrayList<Card>) {
    /*
    Hand contains a collection of Cards and will be held in the Player class
     */
    var cards = hand

    /***
     * This function adds cards to the hand
     * params: c card to add
     * returns: none
     */
    fun addCard(c: Card) {
        cards.add(c)
    }

    /***
     * This function removes a card from the hand
     * params: c card to remove
     * returns: none
     */
    fun removeCard(c: Card) {
        cards.remove(c)
    }

}