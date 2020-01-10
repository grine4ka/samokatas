package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.ceil

fun main() {
    output {
        val n = readInt()
        val gold = readIntArray(n)
        gold.sort()
        val middle = n / 2
        var sum1 = 0
        var sum2 = 0
        for (i in 0 until n) {
            if (i < middle) {
                sum1 += gold[i]
            } else {
                sum2 += gold[i]
            }
        }
        println("Max diff is ${abs(sum1 - sum2)}")
    }
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/gold4.in").inputStream()
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
