import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1_2KtTest{
    @Test
    fun testRetreiveNumber() {
        val str = "6rqskvckjzq2qzrnbxjmlthreeeight6hrs"
        val res = findDigitsInText(str)
        val first = findFirstDigit(str)
        val last = findLastDigit(str)
        println(res)
        println("$first$last")
    }
}
