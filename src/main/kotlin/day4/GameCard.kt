package day4

class GameCard(input: List<String>) {
    val cards: List<Card>

    init {
        cards = input.withIndex().map {
            val splitted = it.value.split(":", "|")
            Card(it.index, getNumbers(splitted[1]), getNumbers(splitted[2]))
        }
    }

    private fun getNumbers(s: String): List<Int> {
        return s.trim().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
    }

    fun getWinningScores(): List<Int> {
        return cards.map { it.getScore() }
    }

    fun getFinalStack(): Int {
        val stack = cards.map { it.id to 1 }.toMap().toMutableMap()
        cards.forEach { c ->
            val nbCopy = stack[c.id]!!
            for (x in 1..nbCopy) {
                for (i in 1..c.getCardsIdToAdd()) {
                    if (stack[c.id + i] != null) {
                        stack[c.id + i] = stack[c.id + i]!! + 1
                    }
                }

            }
        }
        return stack.values.sum()
    }

}

data class Card(val id: Int, val winningNumbers: List<Int>, val numbers: List<Int>) {
    fun getScore(): Int {
        return Math.pow(2.0, numbers.filter { winningNumbers.contains(it) }.size.minus(1).toDouble()).toInt()
    }

    fun getCardsIdToAdd(): Int {
        return numbers.filter { winningNumbers.contains(it) }.size
    }
}
