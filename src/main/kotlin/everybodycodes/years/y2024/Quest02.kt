package everybodycodes.years.y2024

import everybodycodes.years.Quest
import everybodycodes.years.readInput
import kotlin.math.max
import kotlin.math.min

class Quest02 : Quest {

    fun part1(): Any {
        val input = readInput("quest02.1", 2024)
        val words = input[0].substring("words:".length).split(",").map { it.trim() }
        val sentence = input[2]
        return sentence.countWords(words)
    }

    fun part2(): Any {
        val input = readInput("quest02.2", 2024)
        val words = input[0].substring("words:".length).split(",").map { it.trim() }
        return input.drop(2)
            .map {
                val result = it.countWordChars(words)
                return@map result
            }
            .sum()
    }
}

fun main() {
    val quest2 = Quest02()
    println(quest2.part1())
    println(quest2.part2())
}

fun String.subword(start: Int, size: Int) : String {
    val from = max(start, 0)
    val to = min(start + size, length)
    return this.substring(from, to)
}

fun String.countWords(words: List<String>) : Int {
    return mapIndexed { index, c ->
        words.map {
            if (subword(index, it.length) == it) {
                1
            } else {
                0
            }
        }.sum()
    }.sum()
}

fun String.countWordChars(words: List<String>) : Int {
    val fullWords = (words + words.map { it.reversed() }).toSet()
    val chars = mutableSetOf<Int>()
    forEachIndexed { index, _ ->
        fullWords.forEach {
            if (subword(index, it.length) == it) {
                (index..<(index + it.length)).forEach { pos -> chars.add(pos) }
            }
        }
    }
    return chars.size
}