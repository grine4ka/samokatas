package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val sum = readInt()
        val coins = readIntArray(n)
        val d = IntArray(sum + 1)
        val p = IntArray(sum + 1)
        d[0] = 0
        for (i in 1..sum) {
            d[i] = Int.MAX_VALUE
            for (j in 0 until n) {
                if (i - coins[j] >= 0 && d[i - coins[j]] + 1 < d[i]) {
                    d[i] = d[i - coins[j]] + 1
                    p[i] = coins[j]
                }
            }
        }
        println("Count of coins will be ${d[sum]}")
        recout(p, sum)
    }
}

private fun PrintWriter.recout(path: IntArray, i: Int) {
    if (i == 0) {
        return
    }
    recout(path, i - path[i])
    if (i - path[i] > 0) {
        print('+')
    }
    print(path[i])
}


/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/change.in").inputStream()
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
