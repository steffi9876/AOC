package DayTwo2020

import org.testng.Assert
import org.testng.annotations.Test

class PasswordTest {


    @Test
    fun testPassword() {
        val passwordListTest = listOf(
            "9-10 b: bbktbbbxhfbpb", "2-10 x: xxnxxxwxxsx", "5-7 w: ghwwdrr",
            "4-6 z: nzzjzk", "7-8 s: szsssswfs"
        )

        val passwordResult = checkPasswords(passwordListTest)
        Assert.assertEquals(1, passwordResult)
    }

    @Test
    fun testPassword2() {
        val passwordListTest = listOf(
            "9-10 b: bbktbbbxhfbpb", "2-10 x: xxnxxxwxxsx", "5-7 w: ghwwdrr",
            "4-6 z: nzzjzk", "7-8 s: szsssswfs"
        )

        val passwordResult = checkPasswordsTwo(passwordListTest)
        Assert.assertEquals(1, passwordResult)
    }
}
