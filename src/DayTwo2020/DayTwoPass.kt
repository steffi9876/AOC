package DayTwo2020

import java.io.File

fun checkPasswords(data: List<String>): Int {
    var validPassCount = 0


    for (passwordData in data) {

        val parts = passwordData.split(" ")// Dela upp raden i delar med mellanslag

        val range = parts[0].split("-")
        val firstNUm = range[0].toInt()  // Första talet
        val secondNum = range[1].toInt() // Andra talet

        val letter = parts[1].substring(0, 1)

        val password = parts[2] // Hämta själva lösenordet

        val count = password.count { it.toString() == letter }// Räkna antalet ggr av tecknet i lösenordet

        if (count in firstNUm..secondNum) {
            validPassCount++
        }
    }

    // Skriv ut antalet giltiga lösenord
    println(validPassCount)

    // Returnera antalet giltiga lösenord
    return validPassCount
}

fun checkPasswordsTwo(data: List<String>): Int {
    var validPassCount = 0

    for (passwordData in data) {
        val parts = passwordData.split(" ")
        val range = parts[0].split("-")
        val firstNum = range[0].toInt() - 1 // Justera för att konvertera till noll-indexerade positioner
        val secondNum = range[1].toInt() - 1 // Justera för att konvertera till noll-indexerade positioner
        val letter = parts[1].substring(0, 1)
        val password = parts[2]

        // Kontrollera om tecknet finns på exakt en av de angivna positionerna
        if ((password[firstNum] == letter[0]) != (password[secondNum] == letter[0])) {
            validPassCount++
        }
    }

    println(validPassCount)
    return validPassCount
}
fun main() {

    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayTwo2020/dataPass").readLines()
    checkPasswords(data)
    checkPasswordsTwo(data)

}