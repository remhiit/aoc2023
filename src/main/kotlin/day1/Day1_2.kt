package day1

import Main

fun main() {
    val inputD1 = Main::class.java.getResource("day1.txt")?.readText()
    var nb = 0
    val calc = inputD1?.split("\r\n")
        ?.filter { it.isNotBlank() }
        ?.map { findFirstDigit(it).plus(findLastDigit(it)).toInt() }
        ?.reduce { acc, i -> acc + i }
    println(calc)
}

val convert = mapOf(
    "one" to "1",
    "1" to "1",
    "two" to "2",
    "2" to "2",
    "three" to "3",
    "3" to "3",
    "four" to "4",
    "4" to "4",
    "five" to "5",
    "5" to "5",
    "six" to "6",
    "6" to "6",
    "seven" to "7",
    "7" to "7",
    "eight" to "8",
    "8" to "8",
    "nine" to "9",
    "9" to "9",
)

fun findFirstDigit(l: String): String {
    return findDigitsInText(l).minByOrNull { it.key }?.value ?: "0"
}

fun findLastDigit(l: String): String {
    return findDigitsInText(l).maxByOrNull { it.key }?.value ?: "0"
}

fun findDigitsInText(l: String): Map<Int, String> {
    return convert.map { d -> Regex(d.key).findAll(l).map { it.range.first }.map { (it to d.value) } }
        .flatMap { it }
        .filter { d -> d.first != -1 }
        .toMap()
}
