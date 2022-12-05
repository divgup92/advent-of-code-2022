package day04

import Day
import Lines
import kotlin.streams.toList

class Day4 : Day() {
    override fun part1(input: Lines) = input.stream().map { line -> getPairs(line) }.filter { pairs ->  isFullOverlap(pairs) }.toList().count()

    private fun getPairs(input: String) = input.split(",").stream().map { i -> i.split("-") }.toList()

    private fun isFullOverlap(pairs: List<List<String>>): Boolean {
        // [a,b] [c,d]
        val (a,b,c,d) = listOf(pairs[0][0].toInt(), pairs[0][1].toInt(), pairs[1][0].toInt(), pairs[1][1].toInt());
        return (a in c..d && b in c..d) || (c in a..b && d in a..b)
    }

    override fun part2(input: Lines) = input.stream().map { line -> getPairs(line) }.filter { pairs ->  isPartialOverlap(pairs) }.toList().count()

    private fun isPartialOverlap(pairs: List<List<String>>): Boolean {
        val (a,b,c,d) = listOf(pairs[0][0].toInt(), pairs[0][1].toInt(), pairs[1][0].toInt(), pairs[1][1].toInt());
        return (a in c..d) || (b in c..d) || (c in a..b) || (d in a..b)
    }
}