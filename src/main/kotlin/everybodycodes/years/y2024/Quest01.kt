package everybodycodes.years.y2024

import everybodycodes.years.Quest
import everybodycodes.years.readInput

class Quest01 : Quest {

    fun part1(): Any = solvePart(name = "quest01", chunkSize = 1)

    fun part2(): Any = solvePart(name = "quest01.2", chunkSize = 2)

    fun part3(): Any = solvePart(name = "quest01.3", chunkSize = 3)
}

fun main() {
    val quest1 = Quest01()
    println(quest1.part1())
    println(quest1.part2())
    println(quest1.part3())
}

private fun solvePart(name: String, chunkSize: Int) : Int {
    val lines = readInput(name, 2024)
    return lines.sumOf { line ->
        line.calculatePotions(chunkSize)
    }
}

private fun String.calculatePotions(chunkSize: Int) : Int {
    var result = 0
    for (i in this.indices step chunkSize) {
        val chunk = this.substring(i, i + chunkSize)
        result += chunk.getPotions()
    }
    return result
}

private fun Char.getPotions() : Int {
    return when (this) {
        'A' -> 0
        'B' -> 1
        'C' -> 3
        'D' -> 5
        else -> 0
    }
}

private fun String.getPotions() : Int {
    if (contains("x")) {
        return replace("x", "").getPotions()
    }
    return when (length) {
        1 -> {
            this[0].getPotions()
        }
        2 -> {
            this[0].getPotions() + this[1].getPotions() + 2
        }
        3 -> {
            this[0].getPotions() + this[1].getPotions() + this[2].getPotions() + 6
        }
        else -> 0
    }
}