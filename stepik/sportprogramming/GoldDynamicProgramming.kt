package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.max

fun main() {
    output {
        val n = readInt()
        var sum = 0L
        val gold = IntArray(n) {
            val g = read().toInt()
            sum += g
            g
        }
        val k = ceil(sum / 2.0).toInt()
        val d = IntArray(k + 1)
        d[0] = 1
        for (i in 0 until n) {
            for (j in k downTo gold[i]) {
                if (d[j - gold[i]] > 0) {
                    d[j] = 1
                }
            }
        }
        var i = k
        while (d[i] == 0) {
            i--
        }
        println("Minimun diff is ${abs((sum - i) - i)}")
    }
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/gold2.in").inputStream()
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
private fun readLongArray(n: Int) = LongArray(n) { read().toLong() }

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) {
    writer.apply(block).flush()
}
