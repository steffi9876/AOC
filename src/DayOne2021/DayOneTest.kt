package DayOne2021
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class DayOneTest {

    @Test
    fun testingPart1(){
        val numbersList = listOf("199", "200", "198", "210")
        val count = numbersList.zipWithNext().count { it.first < it.second }
        assertEquals(2, count)
    }

    @Test
    fun testPart2(){
        val numbersList = listOf("199", "200", "198", "210", "220", "190", "200", "250")
        val count2 = numbersList.map { it.toInt() }.windowed(size = 4).count(){it.takeLast(3).sum() > it.take(3).sum()}
        assertEquals(3, count2)
    }
}