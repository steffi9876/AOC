package DayOne2020

import java.io.File


// https://www.youtube.com/watch?v=o4emra1xm88
// https://github.com/Zordid/adventofcode-kotlin-2020/blob/main/src/main/kotlin/Day01_ReportRepair.kt

fun findSumAfter(numbers : List<Int>) : Int{

    for (num1 in numbers) { // Loopa igenom elementen för att hitta tal 1
        for (num2 in numbers){ // Loopa igenom elementen för att hitta tal 2
            if (num1 + num2 == 2020) { // Om tal 1 + 2 = 2020
                println("Result 1: ${num1 * num2}") // Printa ut detta!
                return num1 * num2
            }
        }
    }
    return 0
}


fun findSumAfterTwo(numbers : List<Int>) : Int {

    for (num1 in numbers) { // Loopa igenom elementen för att hitta tal 1
        for (num2 in numbers){  // Loopa igenom elementen för att hitta tal 2
            for (num3 in numbers) { // Loopa igenom elementen för att hitta tal 3
                if (num1 + num2 + num3 == 2020) {
                    println("Result 2: ${num1 * num2 * num3}")
                    return num1 * num2 * num3
                }
            }
        }
    }
    return 0
}

fun main() {
    val data: List<Int> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2020/SumNumbers").readLines().map { it.toInt() }

    findSumAfter(data)
    findSumAfterTwo(data)

}