package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.max

fun main() {
    output {
        val n = readInt()
        val a = readIntArray(n)
        val sum = IntArray(1 shl n)
        for (mask in 0 until (1 shl n)) {
            sum[mask] = 0
            for (i in 0 until n) {
                if (mask and (1 shl i) != 0) {
                    sum[mask] = sum[mask xor (1 shl i)] + a[i]
                    break
                }
            }
        }
    }
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/rucksack.in").inputStream()
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
