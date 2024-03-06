package DayOne2021

import java.io.File

// https://github.com/jkpr/advent-of-code-2021-kotlin/blob/master/src/day01/Day01.kt
// https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day01.kt



class DayOneAfter

fun countIncreasementAfter(numbers : List<String>) : Int  {
    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2021/NumberFile").readLines()

        val count = data.zipWithNext().count { it.first < it.second } // zipWithNext (1, 2, 3, 4) ger ([1, 2], [2, 3], [3, 4]).

        println("Increased $count times")

    return count
    }

fun countIncreasementAfter2(numbers: List<String>) : Int {
    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2021/NumberFile").readLines()

                       //Konv. till int | skapar ett fönster på 4 att jämföra med | Kollar om de summan av de 3 senaste intarna är större än summan av de 3 nuvarande
    val count2 = data.map { it.toInt() }.windowed(size = 4).count(){it.takeLast(3).sum() > it.take(3).sum()}

    println("Total $count2")
    return count2
}


fun main() {

    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2021/NumberFile").readLines()


    countIncreasementAfter(data)
    countIncreasementAfter2(data)
}
