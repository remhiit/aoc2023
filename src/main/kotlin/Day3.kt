fun main() {
    val input = readFromResource("day3.txt")
    val shematic = Shematic(input)
    println("D3.1: " + shematic.getPartNumbers().map { it.id }.sum())
    println("D3.2: " + shematic.getGears().map { it.value }.sum())
}
