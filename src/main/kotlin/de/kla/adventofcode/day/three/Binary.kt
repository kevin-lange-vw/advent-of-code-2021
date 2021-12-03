package de.kla.adventofcode.day.three

import de.kla.adventofcode.helper.inputFile
import java.io.File

val EXAMPLE_FILE = inputFile("example-3.txt")
val INPUT_FILE = inputFile("input-3.txt")


fun main() {
    println("EXAMPLE:")
    partOne(EXAMPLE_FILE)
    partTwo(EXAMPLE_FILE)
    println("REAL:")
    partOne(INPUT_FILE)
    partTwo(INPUT_FILE)
}

private fun partOne(file: File) {
    var gammaRate = ""
    var epsilonRate = ""
    var numberOfLines = 0

    val positions: MutableMap<Int, Int> = mutableMapOf()

    file.forEachLine {
        numberOfLines++
        it.forEachIndexed { position, element ->
            positions.compute(position) { _, value ->
                if (element == '1') {
                    return@compute (value ?: 0) + 1
                }
                return@compute value ?: 0
            }
        }
    }

    val halfLines = numberOfLines / 2

    val moreCommon = fun() {
        gammaRate += "1"
        epsilonRate += "0"
    }
    val lessCommon = fun() {
        gammaRate += "0"
        epsilonRate += "1"
    }

    positions.values.forEach {
        it.moreCommon(halfLines, moreCommon, lessCommon)
    }

    val powerConsumption = Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)
    println("part one: $powerConsumption")
}

fun Int.moreCommon(halfLines: Int, moreCommon: Runnable, lessCommon: Runnable) {
    if (this > halfLines) {
        moreCommon.run()
    } else {
        lessCommon.run()
    }
}

private fun partTwo(file: File) {
    val oxygenRating = filter(file.readLines(), 0, mostCommonOperation = true)
    val coRating = filter(file.readLines(), 0, mostCommonOperation = false)


    val lifeSupportRating = Integer.parseInt(oxygenRating, 2) * Integer.parseInt(coRating, 2)
    println("part two: $lifeSupportRating")
}

fun filter(lines: List<String>, position: Int, mostCommonOperation: Boolean): String {
    // positive = more 1; negative = more 0
    var mostCommonAtIndex = 0
    lines.forEach {
        val number = Character.getNumericValue(it[position])
        mostCommonAtIndex += if (number == 0) -1 else 1
    }

    val toRemove = if (mostCommonOperation) {
        if (mostCommonAtIndex == 0) {
            '0'
        } else if (mostCommonAtIndex > 0) '0' else '1'
    } else {
        if (mostCommonAtIndex == 0) {
            '1'
        } else if (mostCommonAtIndex < 0) '0' else '1'
    }

    val filtered = lines.filter { it[position] == toRemove }

    if (filtered.size == 1) {
        return filtered[0]
    }
    return filter(filtered, position + 1, mostCommonOperation)
}