package DayTwo2021

import java.io.File

fun horizontal(instructions : List<String>) : Int {

    var depthIncrease = 0
    var depthDecrease = 0
    var forward = 0

    for (instruction in instructions) {
        val parts = instruction.split(" ") // Splitta instruktionerna med hjälp av " "
        val direction = parts[0] // På plats 0 finns riktingen
        val value = parts[1].toInt() // på plats 1 finns en siffra


        when (direction) { // Istället för switch
            "forward" -> forward += value
            "up" -> depthDecrease += value
            "down" -> depthIncrease += value

        }
    }
    val calcDepth = depthIncrease - depthDecrease // Increase - decrease för att hitta rätt djup!

    println("Horizontal position: ${forward * calcDepth}")
    return forward * calcDepth
}


fun horizontal2 (instructions: List<String>) : Int{

    var horizontalPosition = 0
    var depth = 0
    var aim = 0

    for (instruction in instructions) {
        val parts = instruction.split(" ")
        val direction = parts[0]
        val value = parts[1].toInt()

        when (direction) {
            "forward" -> {
                horizontalPosition += value
                depth += aim * value // depth = depth + aim * value
            }
            "up" -> aim -= value
            "down" -> aim += value
        }
    }
    val calc = horizontalPosition * depth
    println("Final: $calc")

    return calc
}


fun main() {
    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayTwo2021/submarineData").readLines()

    horizontal(data)
    horizontal2(data)
}