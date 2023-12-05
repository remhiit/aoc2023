import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameTest {
    @Test
    fun createGame() {
        val g = Game(1, "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        val expected = listOf(
            mapOf("blue" to 3, "red" to 4),
            mapOf("blue" to 6, "red" to 1, "green" to 2),
            mapOf("green" to 2)
        )
        Assertions.assertEquals(expected, g.iteration)
    }

    @Test
    fun isPossibleTestTrue() {
        val g = Game(1, "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        assertTrue { g.isPossibleWith(mapOf("blue" to 6, "red" to 4, "green" to 2)) }
        assertTrue { g.isPossibleWith(mapOf("blue" to 10, "red" to 6, "green" to 5)) }
    }

    @Test
    fun isPossibleTestFalse() {
        val g = Game(1, "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        assertFalse { g.isPossibleWith(mapOf("blue" to 2, "red" to 4, "green" to 3)) }
        assertFalse { g.isPossibleWith(mapOf("blue" to 8, "red" to 1, "green" to 3)) }
        assertFalse { g.isPossibleWith(mapOf("blue" to 8, "red" to 4, "green" to 1)) }
        assertFalse { g.isPossibleWith(mapOf("blue" to 2, "red" to 1, "green" to 1)) }
    }

    @Test
    fun powerTest() {
        val g = Game(1, "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        assertEquals(48, g.power())
    }
}
