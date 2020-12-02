package com.github.aoc2020.day2_kotlin

import java.util.regex.Pattern

class PasswordLine {
    var line: String;
    var min :Int;
    var max : Int;
    var letter : Char = 'a';
    var password: String = "abc";
    var letterCount : Int;
    var valid: Boolean;
    var valid2 : Boolean;
    var letterFirst : Char = '_';
    var letterSecond : Char = '_';

    constructor(line: String) {
        this.line = line
        var regex = """([0-9]*)-([0-9]+) (.): (.*)""".toRegex()
        var match = regex.matchEntire(line)!!.destructured
        min = match.component1().toInt()
        max = match.component2().toInt()
        letter = match.component3()[0]
        password = match.component4()
        letterCount = letter.toString().toRegex().findAll(password).count()
        valid = letterCount in min..max
        letterFirst = password[min-1]
        letterSecond = password[max-1]
        var isFirst = letterFirst == letter
        var isSecond = letterSecond == letter
        valid2 = (isFirst && !isSecond) || (!isFirst && isSecond)
        println("result: $min $max $letter $password $letterCount $valid $valid2")
    }

}