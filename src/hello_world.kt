fun main(args: Array<String>) {
    println("Hello, world!")
    conditions(43)
    conditions(41)
    conditions(42)
    ternaryOp(41)
    ternaryOp(43)
    ternaryOp(42)

}


fun conditions(x: Int) {
    if (x < 42) {
        println("Too little")
    }
    else if (x > 42) {
        println("Too much")
    }
    else {
        println("The answer to life, the universe, and everything")
    }
}

fun ternaryOp(x: Int) {
    val result = if (x != 42) "not right" else "The answer to life, the universe, and everything"
    println(result)
}