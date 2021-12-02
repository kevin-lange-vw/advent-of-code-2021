package de.kla.adventofcode.helper

import java.io.File

fun inputFile(fileName: String): File {
    return File({}::class.java.classLoader.getResource(fileName).toURI())
}