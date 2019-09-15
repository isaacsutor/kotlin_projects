package sabacc
import java.util.ArrayList


class Deck() {
    val deckList = generateDeck()

    /***
     * Function which generates cards for a single suit
     * params: s is a Suit from the sabacc
     * returns: an ArrayList<Card> of Cards which are of the suit requested
     */
    fun generateSuit(s: Suit): ArrayList<Card>{
        return arrayListOf(
            Card(s, Rank.ONE), Card(s, Rank.TWO), Card(s, Rank.THREE),
            Card(s, Rank.FOUR), Card(s, Rank.FIVE), Card(s, Rank.SIX),
            Card(s, Rank.SEVEN), Card(s, Rank.EIGHT), Card(s, Rank.NINE),
            Card(s, Rank.TEN), Card(s, Rank.ELEVEN), Card(s, Rank.COMMANDER),
            Card(s, Rank.MISTRESS), Card(s, Rank.MASTER), Card(s, Rank.ACE)
        )
    }

    /***
     * This function is unused currently but will probably be needed for optimization to add FACECARDS
     * params: none
     * returns: an ArrayList<Card> of Cards which are of suit: FACECARD
     */
    fun generateFaceCards(): ArrayList<Card> {
        val s = Suit.FACECARD
        return arrayListOf(
            Card(s, Rank.THESTAR), Card(s, Rank.THEEVILONE), Card(s, Rank.MODERATION),
            Card(s, Rank.DEMISE), Card(s, Rank.BALANCE), Card(s, Rank.ENDURANCE),
            Card(s, Rank.QWEENOFAIRANDDARKNESS), Card(s, Rank.IDIOT),
            Card(s, Rank.THESTAR), Card(s, Rank.THEEVILONE), Card(s, Rank.MODERATION),
            Card(s, Rank.DEMISE), Card(s, Rank.BALANCE), Card(s, Rank.ENDURANCE),
            Card(s, Rank.QWEENOFAIRANDDARKNESS), Card(s, Rank.IDIOT)
        )
    }

    /***
     * This function generates a Deck of the 76 Cards required to play Sabacc
     * params: none
     * returns: Deck of all Sabacc cards needed for the game
     */
    fun generateDeck(): ArrayList<Card>{
        // Start with bruteforce || will optimize in future
        // Initialize deck with the FaceCards
        val s = Suit.FACECARD
        var deckGen: ArrayList<Card> = arrayListOf(
            Card(s, Rank.THESTAR), Card(s, Rank.THEEVILONE), Card(s, Rank.MODERATION),
            Card(s, Rank.DEMISE), Card(s, Rank.BALANCE), Card(s, Rank.ENDURANCE),
            Card(s, Rank.QWEENOFAIRANDDARKNESS), Card(s, Rank.IDIOT),
            Card(s, Rank.THESTAR), Card(s, Rank.THEEVILONE), Card(s, Rank.MODERATION),
            Card(s, Rank.DEMISE), Card(s, Rank.BALANCE), Card(s, Rank.ENDURANCE),
            Card(s, Rank.QWEENOFAIRANDDARKNESS), Card(s, Rank.IDIOT)
        )

        // remaining "Standard" suits to add
        val suits = listOf(Suit.SABERS, Suit.COINS, Suit.FLASKS, Suit.STAVES)

        /* add "Standard" suits to the deck to complete the deck
           it now contains the full deck of 76 cards */
        for (suitItem in suits){
            deckGen.addAll(generateSuit(suitItem))
        }
        return deckGen

    }



}

