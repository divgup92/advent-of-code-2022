package day02

import Day
import Lines

class Day2 : Day() {

    private val opponentMap = mapOf(
        "A" to GameOptions.ROCK,
        "B" to GameOptions.PAPER,
        "C" to GameOptions.SCISSORS,
    )

    private val myMap = mapOf(
        "X" to GameOptions.ROCK,
        "Y" to GameOptions.PAPER,
        "Z" to GameOptions.SCISSORS,
    )

    private val scoreMap = mapOf(
        GameOptions.ROCK to 1,
        GameOptions.PAPER to 2,
        GameOptions.SCISSORS to 3,
    )

    private val winMap = mapOf(
        GameOptions.SCISSORS to GameOptions.ROCK,
        GameOptions.PAPER to GameOptions.SCISSORS,
        GameOptions.ROCK to GameOptions.PAPER
    )

    private val loseMap = mapOf(
        GameOptions.ROCK to GameOptions.SCISSORS,
        GameOptions.SCISSORS to GameOptions.PAPER,
        GameOptions.PAPER to GameOptions.ROCK
    )

    override fun part1(input: Lines): Any {
        var score = 0
        input.stream().map { line -> line.split(" ") }.forEach { turns ->
            score += getScore(opponentMap[turns[0]]!!, myMap[turns[1]]!!)
        }
        return score
    }

    override fun part2(input: Lines): Any {
        var score = 0
        input.stream().map { line -> line.split(" ") }.forEach { turns ->
            score += getScore(opponentMap[turns[0]]!!, inferMyMove(turns[1], opponentMap[turns[0]]!!))
        }
        return score
    }

    private fun getScore(elf: GameOptions, me: GameOptions) = when {
        elf == me -> 3 + scoreMap[me]!!
        ((me == GameOptions.ROCK && elf == GameOptions.SCISSORS) || (me == GameOptions.SCISSORS && elf == GameOptions.PAPER) || (me == GameOptions.PAPER && elf == GameOptions.ROCK)) -> 6 + scoreMap[me]!!
        else -> scoreMap[me]!!
    }

    private fun inferMyMove(code: String, oppMove: GameOptions) = when (code) {
        "X" -> loseMap[oppMove]!!
        "Y" -> oppMove
        "Z" -> winMap[oppMove]!!
        else -> GameOptions.INVALID
    }
}

enum class GameOptions {
    ROCK, PAPER, SCISSORS, INVALID
}