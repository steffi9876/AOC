package NotDone.DaySeven2021NotDone

import java.io.File


// MISSFÖRSTOD UPPGIFT, EJ LÖST!

fun calc(data: String): Int {
    var count = 0

    val numbers = data.split(",") // Split the data string into individual numbers

    for (i in 0 until numbers.size - 1 step 2) {
        val start = numbers[i].toInt()
        val end = numbers[i + 1].toInt()
        val fuel = if (end > start) (end - start) else (start - end)
        println("Move from $start to $end: $fuel fuel")
            count += fuel // Accumulate the total fuel used
    }

    return count
}
fun main() {
    val data: String = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DaySeven2021/inputDATA").readText()
    println("Data $data")
    val totalFuel = calc(data)
    println("Total fuel used: $totalFuel")
}