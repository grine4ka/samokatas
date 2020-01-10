package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.ceil

fun main() {
    output {
        val n = readInt()
        val t = IntArray(n)
        val d = IntArray(n)
        repeat(n) {
            t[it] = readInt()
            d[it] = readInt()
        }

        var max = 0
        for (mask in 0 until (1 shl n)) {
            var count = 0
            var sum = 0
            for (j in 0 until n) {
                if (mask and (1 shl j) != 0) {
                    if (sum == 0) {
                        sum = t[j]
                        count++
                    } else if (d[j] >= sum) {
                        sum += t[j]
                        count++
                    }
                }
            }
            if (count > max) {
                max = count
            }
        }
        println("Max is $max")
    }
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/time.in").inputStream()
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
