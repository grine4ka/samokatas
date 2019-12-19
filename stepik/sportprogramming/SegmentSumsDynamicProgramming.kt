package ru.bykov.stepik.sportprogramming

import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val sums = IntArray(n)
        repeat(n) {
            val num = read().toInt()
            if (it == 0) {
                sums[it] = num
            } else {
                sums[it] = sums[it-1] + num
            }
        }
        val q = readInt()
        repeat(q) {
            val left = readInt()
            val right = readInt()
            println("Sum between [$left, $right] is ${sums[right] - sums[left-1]}")
        }
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
