package day5

class Almanac(input: List<String>) {
    val seeds : List<String>
    val corespondances : Map<CategoryTransition, List<Range>>

    init {

    }

    fun getStartLocation(): Int {
        TODO("Not yet implemented")
    }
}

data class CategoryTransition(val fromCategory: String, val toCategory: String) {

}

data class Range(val fromId: Int, val toId: Int, val step: Int) {
}
