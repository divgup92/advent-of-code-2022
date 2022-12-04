package day03

import Day
import Lines
import kotlin.streams.toList

class Day3 : Day() {
    override fun part1(input: Lines): Any {
        return input.stream().map { line -> getScore(line) }.toList().sum()
    }

    private fun getScore(input: String): Int {
        val firstHalf = input.substring(0, input.length/2)
        val secondHalf = input.substring(input.length/2, input.length)
        val commonChar = firstHalf.chars().distinct().filter { c -> secondHalf.contains(c.toChar()) }.findAny()
        return mapScore(commonChar.asInt)
    }

    private fun mapScore(c: Int) = when {
        c >= 'a'.code && c <= 'z'.code -> c-'a'.code + 1
        c >= 'A'.code && c <= 'Z'.code -> c-'A'.code + 27
        else -> 0
    }

    override fun part2(input: Lines): Any {
        var group3 = mutableListOf<String>()
        var sum = 0
        for(line in input) {
            if(group3.size == 3) {
                sum += getScoreGroup(group3)
                group3 = mutableListOf()
            }
            group3.add(line)
        }
        return sum + getScoreGroup(group3)
    }

    private fun getScoreGroup(group3: List<String>): Int {
        val commonChar = group3[0].chars().distinct().filter { c -> group3[1].contains(c.toChar()) && group3[2].contains(c.toChar()) }.findAny()
        return mapScore(commonChar.asInt)
    }
}
