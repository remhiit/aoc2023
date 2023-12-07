import day4.GameCard
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test {
    @Test
    fun gameCardScoreTest(){
        val input = readFromResource("day4.txt")
        val game = GameCard(input).getWinningScores()
        assertEquals(13, game.sum())
    }
    @Test
    fun gameCardStackTest(){
        val input = readFromResource("day4.txt")
        val nbCards = GameCard(input).getFinalStack()
        assertEquals(30, nbCards)
    }
}
