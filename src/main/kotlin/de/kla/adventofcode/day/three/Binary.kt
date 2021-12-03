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
                    return@compute (value?: 0) + 1
                }
                return@compute value?: 0
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
    var gammaRate = 0
    var epsilonRate = 0

    file.forEachLine {

    }

    val powerConsumption = gammaRate * epsilonRate
    println("part two: ${powerConsumption}")
}