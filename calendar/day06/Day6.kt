package day06

import Day
import Lines

class Day6 : Day() {
    override fun part1(input: Lines): Any {
        for(i in 0..input[0].length-4) {
            if (input[0].substring(i, i+4).toCharArray().distinct().count() == 4)
                return i + 4
        }
        return -1
    }

    override fun part2(input: Lines): Any {
        for(i in 0..input[0].length-14) {
            if (input[0].substring(i, i+14).toCharArray().distinct().count() == 14)
                return i + 14
        }
        return -1
    }
}