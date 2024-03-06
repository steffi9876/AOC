package NotDone.DaySeven2021NotDone.DayOne2022NotDone

import java.io.File

fun countCalories(data: List<Int>): Int {
    var currentSum = 0
    var maxSum = 0

    // Loopa igenom varje element i listan
    for (calories in data) {
        if (calories < 0) { // Om ett element är negativt är det en tom rad
            currentSum = 0 // Återställ den aktuella summan till noll
        } else {
            currentSum += calories // Lägg till det aktuella kalori-värdet till den aktuella summan
            maxSum = maxOf(maxSum, currentSum) // Uppdatera den maximala summan om den aktuella summan är större
        }
    }
    return maxSum // Returnera den maximala summan av kalorier
}

fun countCalories2(data: List<Int>): Int {
    var currentSum = 0
    val topThreeCalories = mutableListOf<Int>() // Lista för att spara de tre högsta summa kalorierna

    // Loopa igenom varje element i listan med kaloridata
    for (calories in data) {
        if (calories < 0) {
            if (currentSum > 0) { // Om den aktuella summan är större än noll, lägg till den i listan för de tre högsta
                topThreeCalories.add(currentSum)
                topThreeCalories.sortDescending() // Sortera listan i fallande ordning
                if (topThreeCalories.size > 3) { // Om listan är längre än tre element, ta bort det minsta
                    topThreeCalories.removeAt(3)
                }
            }
            currentSum = 0 // Återställ den aktuella summan till noll för nästa sekvens av kalorier
        } else {
            currentSum += calories // Lägg till det aktuella kalori-värdet till den aktuella summan
        }
    }

    // Lägg till den sista sekvensen av kalorier om den inte är tom
    if (currentSum > 0) {
        topThreeCalories.add(currentSum)
        topThreeCalories.sortDescending()
        if (topThreeCalories.size > 3) {
            topThreeCalories.removeAt(3)
        }
    }

    // Returnera summan av de tre högsta kalori-sekvenserna
    return topThreeCalories.sum()
}


fun main() {
    // Läs in kaloridata från filen och konvertera varje rad till en Integer
    val data: List<Int> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2022/dataCalories").readLines()
        .map { if (it.isBlank()) -1 else it.toInt() }

    // Anropa countCalories-funktionen för att beräkna den maximala summan av kalorier
    val maxCalories = countCalories(data)

    // Skriv ut resultatet
    println("Total: $maxCalories")

    val maxThree = countCalories2(data)

    println("Total 3 : $maxThree")


}