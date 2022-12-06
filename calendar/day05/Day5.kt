package day05

import Day
import Lines
import java.util.regex.Matcher
import java.util.regex.Pattern

class Day5 : Day() {
    override fun part1(input: Lines): Any {
        var stacks = mutableListOf<MutableList<Char>>()
        var moves = mutableListOf<MutableList<Int>>()
        val p: Pattern = Pattern.compile("-?\\d+")

        for (i in 0..8) {
            stacks.add(mutableListOf())
        }
        for (line in input) {
            if (line[1] == '1')
                break;
            for (i in 1 until line.length step 4) {
                if (line[i] != ' ') {
                    stacks[i/4].add(line[i])
                }
            }
        }

        for (line in input) {
            if (line.startsWith("move")) {
                val m: Matcher = p.matcher(line)
                var moveList = mutableListOf<Int>()
                while (m.find()) {
                    moveList.add(m.group().toInt())
                }
                moves.add(moveList)
            }
        }

        for(move in moves) {
            for(i in 1..move[0]) {
                stacks[move[2]-1].add(0, stacks[move[1]-1].removeAt(0))
            }
        }

        return stacks.stream().map { stack -> stack[0] }.toList().joinToString("")
    }

    override fun part2(input: Lines): Any {
        var stacks = mutableListOf<MutableList<Char>>()
        var moves = mutableListOf<MutableList<Int>>()
        val p: Pattern = Pattern.compile("-?\\d+")

        for (i in 0..8) {
            stacks.add(mutableListOf())
        }
        for (line in input) {
            if (line[1] == '1')
                break;
            for (i in 1 until line.length step 4) {
                if (line[i] != ' ') {
                    stacks[i/4].add(line[i])
                }
            }
        }

        for (line in input) {
            if (line.startsWith("move")) {
                val m: Matcher = p.matcher(line)
                var moveList = mutableListOf<Int>()
                while (m.find()) {
                    moveList.add(m.group().toInt())
                }
                moves.add(moveList)
            }
        }

        for(move in moves) {
            for(i in 1..move[0]) {
                stacks[move[2]-1].add(i-1, stacks[move[1]-1].removeAt(0))
            }
        }

        return stacks.stream().map { stack -> stack[0] }.toList().joinToString("")
    }
}