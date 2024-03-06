package DayTwo2020

import java.io.File

// https://www.youtube.com/watch?v=MyvJ7G6aErQ
// https://todd.ginsberg.com/post/advent-of-code/2020/day2/

data class PasswordAfter (val password : String, val range : IntRange, var letter : Char)
{
companion object {
    fun parse(line : String) = PasswordAfter (
        password = line.substringAfter(": "),
        letter = line.substringAfter(" ").substringBefore(":").single(),
        range = line.substringBefore(" ").let {
            val (start, end) = it.split("-")
            start.toInt()..end.toInt()
        }
    )
    }
}

fun checkPasswordAfter(data : List<String>){
    var validPassCount = 0

    for (line in data) {
        val passwordData = PasswordAfter.parse(line)
        val count = passwordData.password.count { it == passwordData.letter }

        if (count in passwordData.range) {
            validPassCount++
        }
    }

    println("Number of valid passwords: $validPassCount")
}

fun checkPasswordAfterTwo(data: List<String>) {
    var validPassCount = 0

    for (line in data) {
        val passwordData = PasswordAfter.parse(line)

        val firstPosition = passwordData.password[passwordData.range.first - 1] == passwordData.letter
        val secondPosition = passwordData.password[passwordData.range.last - 1] == passwordData.letter

        if (firstPosition xor secondPosition) {
            validPassCount++
        }
    }

    println("Number of valid passwords: $validPassCount")
}


fun main() {
    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayTwo2020/dataPass").readLines()
    checkPasswordAfter(data)
    checkPasswordAfterTwo(data)
}