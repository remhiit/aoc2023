package day2

import Main

fun main() {
    val input = Main::class.java.getResource("day2.txt")?.readText()!!
    //12 red cubes, 13 green cubes, and 14 blue cubes
    val bag = mapOf("red" to 12, "green" to 13, "blue" to 14)
    println(jobDay2_1(input, bag))
}

fun jobDay2_1(input: String, bag: Map<String, Int>): Int {
    val games = input.split("\r\n").filter { it.isNotBlank() }.map {
        val split = it.split(":")
        Game(split[0].replace("day2.Game ", "").toInt(), split[1])
    }.toList()
    return games.filter { it.isPossibleWith(bag) }.map { it.id }.sum()
}

