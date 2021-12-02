package de.kla.adventofcode.day.two

import de.kla.adventofcode.helper.inputFile
import kotlin.math.absoluteValue

fun main() {
    partOne()
}

private fun partOne() {
    var depth = 0
    var distance = 0

    inputFile("input-2.txt").forEachLine {
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
