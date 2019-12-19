package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.max

fun main() {
    output {
        val n = readInt()
        val a = readIntArray(n)
        val m = readInt()
        val b = readIntArray(m)
        val d = Array(n + 1) {
            IntArray(m + 1)
        }
        for (i in 0..n) {
            d[i][0] = 0
        }
        for (j in 0..m) {
            d[0][j] = 0
        }
        val path = Array(n + 1) { IntArray(m + 1) }
        for (i in 1..n) {
            for (j in 1..m) {
                if (d[i - 1][j] > d[i][j - 1]) {
                    d[i][j] = d[i - 1][j]
                    path[i][j] = d[i-1][j]
                } else {
                    d[i][j] = d[i][j - 1]
                    path[i][j] = d[i][j - 1]
                }
                if (a[i - 1] == b[j - 1] && (d[i - 1][j - 1] + 1 > d[i][j])) {
                    d[i][j] = d[i - 1][j - 1] + 1
                    path[i][j] = d[i - 1][j - 1] + 1
                }
            }
        }
        println("Longest common subsequence is ${d[n][m]}")
        println("Path of longest subsequence is ")
        recout(path, a, n, m)
    }
}

private fun PrintWriter.recout(p: Array<IntArray>, a: IntArray, i: Int, j: Int) {
    if (i <= 0 || j <= 0) {
        return
    }
    when {
        p[i][j] == p[i - 1][j] -> recout(p, a, i - 1, j)
        p[i][j] == p[i][j - 1] -> recout(p, a, i, j - 1)
        else -> {
            recout(p, a, i - 1, j - 1)
            print("${a[i - 1]} ")
        }
    }
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/seq2.in").inputStream()
private val OUTPUT = System.out

private val reader = INPUT.bufferedReader()
private var tokenizer: StringTokenizer = StringTokenizer("")
private fun read(): String {
    if (tokenizer.hasMoreTokens().not()) {
        tokenizer = StringTokenizer(reader.readLine() ?: return "", " ")
    }
    return tokenizer.nextToken()
}

private fun readLn() = reader.readLine()!!
private fun readInt() = read().toInt()
private fun readIntArray(n: Int) = IntArray(n) { read().toInt() }

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) {
    writer.apply(block).flush()
}
