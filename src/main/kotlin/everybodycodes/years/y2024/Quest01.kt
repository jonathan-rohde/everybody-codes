package everybodycodes.years.y2024

import everybodycodes.years.Quest

class Quest01 : Quest {

    fun part1(): Any {
        val lines = readInput("quest01", 2024)
        return lines.map { line ->
            line.map {
                when (it) {
                    'A' -> 0
                    'B' -> 1
                    'C' -> 3
                    else -> 0
                }
            }.sum()
        }.sum()
    }

    fun part2(): Any {
        val lines = readInput("quest01.2", 2024)
        return lines.map { line ->
            var r = 0
            for (i in line.indices step 2) {
                val a = line[i]
                val b = line[i + 1]
                var potions = 0
                potions += a.getPotions() + b.getPotions()
                if (a.isEnemy() && b.isEnemy()) {
                    potions += 2
                }
                r += potions
            }
            return@map r
        }.sum()
    }

    fun part3(): Any {
        val lines = readInput("quest01.3", 2024)
        return lines.map { line ->
            var r = 0
            for (i in line.indices step 3) {
                val p = "${line[i]}${line[i + 1]}${line[i + 2]}".getPotions()
                r += p
            }
            return@map r
        }.sum()
    }
}

fun main() {
    val quest1 = Quest01()
    println(quest1.part1())
    println(quest1.part2())
    println(quest1.part3())
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

private fun Char.isEnemy(): Boolean {
    return this in 'A'..'D'
}

private fun String.containsOtherMob(c: Char): Boolean {
    return filter { it.isEnemy() }
        .any { it != c }
}

private fun String.getPotions() : Int {
    if (length == 1) {
       return this[0].getPotions()
    } else if (length == 2) {
        if (contains("x")) {
            return replace("x", "").getPotions()
        }
        return this[0].getPotions() + this[1].getPotions() + 2
    } else if (length == 3) {
        if (contains("x")) {
            return replace("x", "").getPotions()
        }
        return this[0].getPotions() + this[1].getPotions() + this[2].getPotions() + 6
    }
    return 0
}