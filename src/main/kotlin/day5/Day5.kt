package day5

import readFromResource

fun main() {
    val input = readFromResource("day5.txt")
    val g = Almanac(input)
    println("D5.1: ${g.getStartLocation()}")
    //println("D5.2: ${game.getFinalStack()}")
}
