package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.max

private const val TMAX = 20004

fun main() {
    output {
        val n = readInt()
        val t = IntArray(n)
        val d = IntArray(n)
        repeat(n) {
            t[it] = readInt()
            d[it] = readInt()
        }

        val solution = Array(n + 1) {
            IntArray(TMAX)
        }
        for (i in 0 until n) {
            for (cur in 0 until TMAX) {
                solution[i + 1][cur] = max(solution[i + 1][cur], solution[i][cur])
                if (cur > d[i]) continue
                solution[i + 1][cur + t[i]] = max(solution[i + 1][cur + t[i]], solution[i][cur] + 1)
            }
        }

        println("Max is ${solution[n].max()}")
    }
}

private fun dynamic(idx: Int, start: Int, t: IntArray, d: IntArray): Int {
    if (idx == t.size) {
        return 0
    }
    if (start > d[idx]) {
        return 0
    }

    return max(
            dynamic(idx+1, start + t[idx], t, d) + 1,
            dynamic(idx+1, start, t, d)
    )
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/time2.in").inputStream()
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
