package DayTwo2021

import org.testng.Assert
import org.testng.annotations.Test

class DayTwoTest {
    @Test
    fun testDayTwo() {
        val instruc = listOf(
            "forward 5",
            "up 3",
            "down 6",
            "forward 10",
            "down 2"
        )
        val position = horizontal(instruc)
        Assert.assertEquals(75, position)
    }

    @Test
    fun testDayTwoPartTwo() {
        val instruc = listOf(
            "forward 5",
            "up 3",
            "down 6",
            "forward 10",
            "down 2"
        )
        val position = horizontal2(instruc)
        Assert.assertEquals(450, position)
    }

}