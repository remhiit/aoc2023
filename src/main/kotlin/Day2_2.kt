fun main() {
    val input = Main::class.java.getResource("day2_1.txt")?.readText()!!
    println(jobDay2_2(input))
}

fun jobDay2_2(input: String): Int {
    val games = input.split("\r\n").filter { it.isNotBlank() }.map {
        val split = it.split(":")
        Game(split[0].replace("Game ", "").toInt(), split[1])
    }.toList()
    return games.map { it.power() }.sum()
}
