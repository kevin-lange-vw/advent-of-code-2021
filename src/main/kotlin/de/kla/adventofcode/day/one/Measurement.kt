package de.kla.adventofcode.day.one

import java.io.File

fun main() {
    var increasedCounter = 0
    var lastNumber = Int.MAX_VALUE

    inputFile().forEachLine {
        val currentNumber = it.toInt()
        if (lastNumber < currentNumber) {
            increasedCounter++
        }
        lastNumber = currentNumber
    }
    println(increasedCounter)
}

class Measurement

fun inputFile(): File {
    return File(Measurement::class.java.classLoader.getResource("input-1.txt").toURI())
}