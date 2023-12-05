

fun main() {
    val inputD1 = Main::class.java.getResource("day1_1.txt")?.readText()
    val calc = inputD1?.split("\r\n")
        ?.filter { it.isNotBlank() }
        ?.map { it.find { c -> c.isDigit() }.toString().plus(it.findLast { c -> c.isDigit() }.toString()).toInt()        }
        ?.reduce { acc, i -> acc + i }
    println(calc)
}
