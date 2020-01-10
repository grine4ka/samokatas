package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    output {
        val n = readInt()
        val gold = readIntArray(n)
        var minSumDiff = gold.sum().toLong()
        var minSumDiffMask = 0
        for (mask in 0 until (1 shl n)) {
            var s1 = 0L
            var s2 = 0L
            for (j in 0 until n) {
                if (mask and (1 shl j) != 0) {
                    s1 += gold[j]
                } else {
                    s2 += gold[j]
                }
            }
            if (abs(s1 - s2) < minSumDiff) {
                minSumDiff = abs(s1 - s2)
                minSumDiffMask = mask
            }
        }
        println("Minimum diff of gold is $minSumDiff")
    }
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/gold3.in").inputStream()
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
