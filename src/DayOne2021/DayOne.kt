package DayOne2021

import java.io.File


    fun countIncreasement(){
        val data : List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2021/NumberFile").readLines()

        var count = 0

        for (i in 1 until data.size){
            val currentNumber = data[i].toInt() // Konvertera nuvarande element till int
            val previousNumber = data[i - 1].toInt() // Konvertera föregående element till int

            if (currentNumber > previousNumber) // Jämför dessa med varandra
                count++ // Om det stämmer så plussas count på
        }
        println("Increased $count times")
    }

fun countIncreasement2(){
    val data : List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2021/NumberFile").readLines()

    var count = 0


    for (i in 0 until data.size - 3) {

        // Konvertera talen till intar!
        val firstNumber = data[i].toInt()
        val secondNumber = data[i + 1].toInt()
        val thirdNumber = data[i + 2].toInt()

        // Beräkna summan av de tre talen
        val totSum = firstNumber + secondNumber + thirdNumber

        // Beräkna summan av de tre nästa talen efter de tre ursprungliga
        val nextThreeSum = data.subList(i + 1, i + 4).sumOf { it.toInt() }

        if (totSum < nextThreeSum)
            count++
    }
    println("Sliding window increased $count times")
}

fun main() {
    countIncreasement()
    countIncreasement2()
}


//Increased 1266 times
//Sliding window increased 1217 times