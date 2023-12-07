import day3.Num
import day3.Shematic
import day3.Symbol
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.awt.Point

class ShematicTest {

    @Test
    fun findNumbersInRowTest() {
        val input = "467..114.."
        val result = Shematic(listOf(input))
        assertEquals(listOf(Num(467, Point(0, 0), Point(2, 0)), Num(114, Point(5, 0), Point(7, 0))), result.numbers)
    }
    @Test
    fun findSymbolsInRowTest() {
        val input = "...\$.*...."
        val result = Shematic(listOf(input))
        assertEquals(listOf(Symbol("\$", Point(3, 0)), Symbol("*", Point(5, 0))), result.symbols)
    }

    @Test
    fun getPartNumbersTest(){
        val input = readFromResource("day3Test.txt")
        val result = Shematic(input).getPartNumbers()
        println(result.map { it.id })
        assertEquals(4361, result.map { it.id }.sum())
    }

    @Test
    fun gearTest(){
        val input = readFromResource("day3Test.txt")
        val result = Shematic(input).getGears()
        println(result.map { it.value })
        assertEquals(467835, result.map { it.value }.sum())
    }
}
