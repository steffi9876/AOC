package DayOne2020

import java.io.File


// Hitta två tal i listan som ger summan 2020

fun findSum(inputData: List<String>): Int {
    for (i in inputData.indices) { // Itererar över alla index för att få tillgång till alla element i filen

        val num1 = inputData[i].toInt() // Konverterar tal 1 till int

        for (j in (i + 1) until inputData.size) {// Iterera över resten av elementen för att hitta ett andra tal att summera den första med!

            val num2 = inputData[j].toInt() // Konverterar tal 2 till int

            if (num1 + num2 == 2020) { // Om summan av de två numren = 2020

                return num1 * num2 // Returnera summan!
            }
        }
    }
    return 0 // Annars returnera 0
}

// Hitta 3 tal i listan som ger summan 2020

fun findSumPartTwo(inputData: List<String>): Int {
    for (i in inputData.indices) { // Itererar över alla index för att få tillgång till alla element i filen

        val num1 = inputData[i].toInt() // Samma, konvertera till int

        for (j in i + 1 until inputData.size) { // Samma, hitta det andra ttalet att summera med!

            val num2 = inputData[j].toInt() // Konvertera det talet till int

            for (k in j + 1 until inputData.size) { // Itererar över resten av elementen för att hitta tal 3

                val num3 = inputData[k].toInt() // Konvertera det talet till int också

                if (num1 + num2 + num3 == 2020) { // Om summan av de tre = 2020

                    return num1 * num2 * num3 // Returnera produkten av de tre numrena
                }
            }
        }
    }
    return 0 // Annars returnera 0
}

fun main() {
    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayOne2020/SumNumbers").readLines()
    val result = findSum(data)
    println("Result: $result")

    val resultTwo = findSumPartTwo(data)
    println("Result two : $resultTwo")
}
