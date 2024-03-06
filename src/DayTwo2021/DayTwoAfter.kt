package DayTwo2021

import java.io.File

// https://todd.ginsberg.com/post/advent-of-code/2021/day2/
// https://www.youtube.com/watch?v=4OAlN7lG4Z4

fun horizontalAfter() {
    
    val data: List<String> = File("/Users/stephanie/Desktop/Javamapp/AOC/src/DayTwo2021/submarineData").readLines()

    // Skapa en instans av Day02 och använd den för att lösa båda delarna av problemet
    val day02 = Day02(data)
    val part1Result = day02.horizontalOne() // Ropar på både funktionerna här uppe
    val part2Result = day02.horizontalTwo()

    // Skriv ut resultaten för del 1 och del 2
    println("Horizontal position 1: $part1Result")
    println("Horizontal position 2: $part2Result")
}


class Day02(input: List<String>) { // Tar in listan av instruktioner för ubåten

    // Konvertera varje instruktion till en Command-instans och lagra dem i en lista
    private val commando = input.map { Command.of(it) } // up, forward etc. 

    // Funktion för att lösa del 1 av problemet
    fun horizontalOne(): Int =
        // Utför alla instruktioner för ubåten och beräkna svaret
        commando.fold(Submarine()) { submarine, command -> submarine.directionOne(command) }.answer()

    // Funktion för att lösa del 2 av problemet
    fun horizontalTwo(): Int =
        // Samma här
        commando.fold(Submarine()) { submarine, command -> submarine.directionTwo(command) }.answer()
}

// En dataklass som representerar ubåtens tillstånd
private data class Submarine(val depth: Int = 0, val position: Int = 0, val aim: Int = 0) {
    // Funktion för att beräkna det slutgiltiga svaret
    fun answer() = depth * position

    // a - uppgfiten
    fun directionOne(command: Command): Submarine =
        // when sats för att se instruktioner för ubåten
        when (command.name) {
            "forward" -> copy(position = position + command.amount)
            "down" -> copy(depth = depth + command.amount)
            "up" -> copy(depth = depth - command.amount)
            else -> error("Ogiltig instruktion")
        }

    // b - uppgiften
    fun directionTwo(command: Command) =
        // when sats för att se instruktioner för ubåten
        when (command.name) {
            "forward" -> copy(
                position = position + command.amount,
                depth = depth + (aim * command.amount)
            )
            "down" -> copy(aim = aim + command.amount)
            "up" -> copy(aim = aim - command.amount)
            else -> error("Ogiltig instruktion")
        }
}

// En klass som representerar en ubåtsinstruktion
private class Command(val name: String, val amount: Int) {
    companion object {
        // En factory-metod för att skapa en Command-instans från en sträng
        fun of(input: String) = input.split(" ").let { Command(it.first(), it.last().toInt()) }
    }
}


fun main() {
    horizontalAfter()
}