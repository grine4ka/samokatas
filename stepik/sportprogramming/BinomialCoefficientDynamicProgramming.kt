package ru.bykov.stepik.sportprogramming

import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val k = readInt()
        val c = Array(n + 1) {
            LongArray(n + 1)
        }
        for (i in 0..n) {
            c[i][0] = 1L
            c[i][i] = 1L
        }
        for (i in 1..n) {
            for (j in 1 until i) {
                c[i][j] = c[i-1][j-1] + c[i-1][j]
            }
        }
        println("Binomial coefficient C $n by $k equals ${c[n][k]}")
    }
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
private fun readIntArray(n: Int) = IntArray(n) { read().toInt() }

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) {
    writer.apply(block).flush()
}
