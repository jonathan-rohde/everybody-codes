package everybodycodes.years.y2024

import everybodycodes.years.Quest
import everybodycodes.years.readInput

class Quest02 : Quest {

    fun part1(): Any {
        val input = readInput("quest02.1", 2024)
        val words = input[0].substring("words:".length).split(",").map { it.trim() }
        val sentence = input[2]


        return sentence.mapIndexed { index, c ->
            words.map {
                if (sentence.subword(index, it.length) == it) {
                    1
                } else {
                    0
                }
            }.sum()
        }.sum()
    }
}

fun main() {
    val quest2 = Quest02()
    println(quest2.part1())
}

fun String.subword(start: Int, size: Int) : String? {
    if (start in indices && start + size in indices) {
        return this.substring(start, start + size)
    }
    return null
}