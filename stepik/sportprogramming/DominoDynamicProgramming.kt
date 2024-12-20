package ru.bykov.stepik.sportprogramming

import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val m = readInt()
        println(solution(n, m))
    }
}

private fun solution(n: Int, m: Int): Int {
    var tmp: Int
    var first = 0
    var second = 1
    for (i in 1..n) {
        tmp = first + second
        first = second
        second = tmp%m
    }
    return second
}

/** IO code start */
private val INPUT = System.`in`
private val OUTPUT = System.out

private val reader = INPUT.bufferedReader()
private var tokenizer: StringTokenizer = StringTokenizer("")
private fun read(): String {
    if (tokenizer.hasMoreTokens().not()) {
        tokenizer = StringTokenizer(reader.readLine() ?: return "", " ")
    }
    return tokenizer.nextToken()
}

private fun readInt() = read().toInt()

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) { writer.apply(block).flush() }
