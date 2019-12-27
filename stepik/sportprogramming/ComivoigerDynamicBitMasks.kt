package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*

private const val INF = Int.MAX_VALUE

fun main() {
    output {
        val n = readInt()
        val a = Array(n) {
            readIntArray(n)
        }
        val d = Array(1 shl n) {
            IntArray(n) { INF }
        }
        val p = Array(1 shl n) {
            IntArray(n) { INF }
        }
        d[0][0] = 0
        for (mask in 0 until (1 shl n)) {
            for (i in 0 until n) {
                if (d[mask][i] == INF) continue
                for (j in 0 until n) {
                    if ((mask and (1 shl j) == 0) && d[mask xor (1 shl j)][j] > d[mask][i] + a[i][j]) {
                        d[mask xor (1 shl j)][j] = d[mask][i] + a[i][j]
                        p[mask xor (1 shl j)][j] = i
                    }
                }
            }
        }
        println("Solution is ${d[(1 shl n) - 1][0]}")
        recout(p, (1 shl n) - 1, 0)
    }
}

private fun PrintWriter.recout(p: Array<IntArray>, mask: Int, j: Int) {
    print("$j ")
    if (p[mask][j] == 0) return
    recout(p, mask xor (1 shl j), p[mask][j])
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/salesman2.in").inputStream()
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
