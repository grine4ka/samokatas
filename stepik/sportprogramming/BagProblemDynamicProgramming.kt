package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.max

fun main() {
    output {
        val n = readInt()
        val maxWeight = readInt()
        val w = IntArray(n + 1)
        val c = IntArray(n + 1)
        repeat(n) {
            w[it + 1] = readInt()
            c[it + 1] = readInt()
        }
        val d = Array(n + 1) {
            IntArray(maxWeight + 1)
        }
        for (i in 0 until n) {
            for (j in 0..maxWeight) {
                if (j + w[i + 1] <= maxWeight && (d[i][j] + c[i + 1] > d[i + 1][j + w[i + 1]])) {
                    d[i + 1][j + w[i + 1]] = d[i][j] + c[i + 1]
                }
                d[i + 1][j] = max(d[i + 1][j], d[i][j])
            }
        }
        println("Max value of all things in a bag is ${d[n][maxWeight]}")
        recout(d, w, n, maxWeight)
    }
}

private fun PrintWriter.recout(d: Array<IntArray>, w: IntArray, i: Int, j: Int) {
    if (d[i][j] == 0) {
        return
    }
    if (d[i - 1][j] == d[i][j]) {
        recout(d, w,i - 1, j)
    } else {
        recout(d, w, i -1, j - w[i])
        print("$i ")
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
