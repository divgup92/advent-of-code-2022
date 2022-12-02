package day01

import Day
import Lines
import kotlin.math.max

class Day1 : Day() {
    override fun part1(input: Lines): Any {
        var sum = 0
        var curSum = 0
        for(line in input) {
            if(line == "") {
                sum = max(sum, curSum)
                curSum = 0
            } else {
                curSum += line.toInt()
            }
        }
        return max(curSum, sum)
    }

    override fun part2(input: Lines): Any {
        var sum = mutableListOf<Int>()
        var curSum = 0
        for(line in input) {
            if(line == "") {
                sum.add(curSum)
                curSum = 0
            } else {
                curSum += line.toInt()
            }
        }
        sum.add(curSum)
        sum.sort()
        sum.forEach(System.out::println)
        return sum.takeLast(3).sum()
    }
}