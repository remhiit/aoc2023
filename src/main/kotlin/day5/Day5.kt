package day5

import day4.GameCard
import readFromResource

fun main() {
    val input = readFromResource("day5.txt")
    val g = Garden(input)
    println("D5.1: ${g.getStartLocation()}")
    //println("D5.2: ${game.getFinalStack()}")
}
