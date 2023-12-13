import day5.Almanac
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test {
    @Test
    fun gardenStartLocationTest() {
        val input = readFromResource("day5.txt")
        val almanac = Almanac(input)
        assertEquals(35, almanac.getStartLocation())
    }
}
