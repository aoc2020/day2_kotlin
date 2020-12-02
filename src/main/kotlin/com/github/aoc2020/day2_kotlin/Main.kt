@file:JvmName("Main")

package com.github.aoc2020.day2_kotlin

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

fun main() {
    println("hello")
    var passwords = readFile("input.txt")
    var valids = passwords.stream().filter(PasswordLine::valid).count()
    var valids2 = passwords.stream().filter(PasswordLine::valid2).count()
    println("answer 1: $valids")
    println("answer 2: $valids2")
}

fun readFile(fileName: String) : List<PasswordLine> {
    return Files.lines(Path.of(fileName))
        .map { line -> PasswordLine(line) }
        .collect(Collectors.toUnmodifiableList())
}