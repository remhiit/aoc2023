import day5.Garden
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day5Test {
    @Test
    fun gardenStartLocationTest() {
        val input = readFromResource("day5.txt")
        val garden = Garden(input)
        assertEquals(35, garden.getStartLocation())
    }
}
