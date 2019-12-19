package ru.bykov.stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val m = readInt()
        val sums = Array(n + 1) { IntArray(m + 1) }
        repeat(n) { i ->
            repeat(m) { j ->
                val num = read().toInt()
                if (i == 0 && j == 0) {
                    sums[i+1][j+1] = num
                } else if (i == 0) {
                    sums[i+1][j+1] = sums[i+1][j] + num
                } else if (j == 0) {
                    sums[i+1][j+1] = sums[i][j+1] + num
                } else {
                    sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + num
                }
            }
        }
        var sumAll = 0L
        val q = readInt()
        repeat(q) {
            val x1 = readInt()
            val x2 = readInt()
            val y1 = readInt()
            val y2 = readInt()
            val sum = sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1]
            sumAll += sum
            println("Sum in triangle [$x1, $x2, $y1, $y2] is $sum")
        }
        println("All sum is $sumAll")
    }
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/rectangle.in").inputStream()
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
private fun readIntArray(n: Int) = IntArray(n) { read().toInt() }

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) {
    writer.apply(block).flush()
}
