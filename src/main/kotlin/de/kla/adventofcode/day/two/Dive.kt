package de.kla.adventofcode.day.two

import de.kla.adventofcode.helper.inputFile
import java.io.File
import kotlin.math.absoluteValue

val EXAMPLE_FILE = inputFile("example-2.txt")
val INPUT_FILE = inputFile("input-2.txt")

fun main() {
    println("EXAMPLE:")
    partOne(EXAMPLE_FILE)
    partTwo(EXAMPLE_FILE)
    println("REAL:")
    partOne(INPUT_FILE)
    partTwo(INPUT_FILE)
}

private fun partOne(file: File) {
    var depth = 0
    var distance = 0

    file.forEachLine {
        if (it.startsWith("forward ")) {
            distance += it.substringAfter("forward ").toInt()
        }
        if (it.startsWith("up ")) {
            depth -= it.substringAfter("up ").toInt()
        }
        if (it.startsWith("down ")) {
            depth += it.substringAfter("down ").toInt()
        }
    }

    println("part One: ${depth.absoluteValue * distance}")
}

private fun partTwo(file: File) {
    var depth = 0
    var distance = 0
    var aim = 0

    file.forEachLine {
        if (it.startsWith("forward ")) {
            val number = it.substringAfter("forward ").toInt()
            distance += number
            depth += (number * aim)
        }
        if (it.startsWith("up ")) {
            aim -= it.substringAfter("up ").toInt()
        }
        if (it.startsWith("down ")) {
            aim += it.substringAfter("down ").toInt()
        }
    }

    println("part two: ${depth.absoluteValue * distance}")
}
