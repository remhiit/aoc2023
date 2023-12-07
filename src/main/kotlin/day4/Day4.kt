package day4

import readFromResource

fun main() {
    val input = readFromResource("day4.txt")
    val game = GameCard(input)
    println("D4.1: ${game.getWinningScores().sum()}")
    println("D4.2: ${game.getFinalStack()}")
}
