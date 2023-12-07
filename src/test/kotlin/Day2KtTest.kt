import day2.jobDay2_1
import day2.jobDay2_2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2KtTest {

    @Test
    fun job2_1Test() {
        val input = Day2KtTest::class.java.getResource("day2.txt")?.readText()!!
        val bag = mapOf("red" to 12, "green" to 13, "blue" to 14)
        assertEquals(8, jobDay2_1(input, bag))
    }
    @Test
    fun job2_2Test() {
        val input = Day2KtTest::class.java.getResource("day2.txt")?.readText()!!
        assertEquals(2286, jobDay2_2(input))
    }
}
