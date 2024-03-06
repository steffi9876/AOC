package DayOne2020

import org.testng.Assert
import org.testng.annotations.Test
class DayOneSumTest {

    @Test
    fun testFindSumAfter() {
        val numbersList = listOf(1000, 1020, 1980, 2100)
        val resultSum = findSumAfter(numbersList)
        Assert.assertEquals(1020000, resultSum)
    }

    @Test
    fun testFindSumAfterTwo() {
        val numbersList = listOf(500, 500, 1020, 1980, 2100)
        val resultSumTwo = findSumAfterTwo(numbersList)
        Assert.assertEquals(255000000, resultSumTwo)
    }
}