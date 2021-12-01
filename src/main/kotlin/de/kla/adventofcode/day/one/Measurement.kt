package de.kla.adventofcode.day.one

import java.io.File

fun main() {
    individualIncreases()
    sumIncreases()
}

fun individualIncreases() {
    var increasedCounter = 0
    var lastNumber = Int.MAX_VALUE

    inputFile().forEachLine {
        val currentNumber = it.toInt()
        if (lastNumber < currentNumber) {
            increasedCounter++
        }
        lastNumber = currentNumber
    }
    println("individual increases:$increasedCounter")
}

fun sumIncreases() {
    val twoLineOffset = 2
    var increasedCounter = 0 - twoLineOffset

    var number1 = 0
    var number2 = 0
    var number3 = 0

    var lastSum = Int.MAX_VALUE

    inputFile().forEachLine {
        val currentNumber = it.toInt()

        number3 = number2
        number2 = number1
        number1 = currentNumber

        val currentSum = number1 + number2 + number3
        if (lastSum < currentSum) {
            increasedCounter++
        }
        lastSum = currentSum
    }
    println("sum increases:$increasedCounter")
}

class Measurement

fun inputFile(): File {
    return File(Measurement::class.java.classLoader.getResource("input-1.txt").toURI())
}