package sabacc

class Pot(initialAmount: Int){
    /*
    Pot contains an amount of money... may change to be abstract and have Sabacc and Main pot types but they don't act
    differently so is probably unnecessary, also used for players personal banks (pots)
     */
    var amount = initialAmount

    /***
     * This function increases the amount in the Pot
     * param: amountAdd is the amount to add
     * return: none
     */
    fun increasePot(amountAdd: Int){
        amount += amountAdd
    }

    /***
     * This function decreases the amount in the Pot
     * param: amountAdd is the amount to add
     * return: none
     */
    fun decreasePot(amountSub: Int){
        amount -= amountSub
    }


}