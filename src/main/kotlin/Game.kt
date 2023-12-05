class Game(val id: Int, input: String) {
    val iteration: List<Map<String, Int>>

    init {
        iteration = input.split(";")
            .map {
                it.split(",")
                    .map {
                        val list = it.trim().split(" ")
                        list[1] to list[0].toInt()
                    }
                    .toMap()
            }
    }
    fun isPossibleWith(bag: Map<String, Int>): Boolean {
        return iteration.filter { coloredCubes ->
            bag.filter { it.value >= coloredCubes.getOrDefault(it.key, 0) }
                .size == bag.size
        }.size == iteration.size
    }

    fun power(): Int {
        return iteration.flatMap { it.entries }
            .groupBy { it.key }
            .map {it.value.map { it.value }.max() }
            .reduce { acc, i -> acc * i }
    }
}
