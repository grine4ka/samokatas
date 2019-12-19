package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*

private const val SMAX = 100000
fun main() {
    output {
        val n = readInt()
        val x = readInt()
        val a = readIntArray(n)

        val d = Array(n) { IntArray(2 * SMAX) }
        // d[i][s] - число способов набрать сумму (s - SMAX) первыми числами a[0], ..., a[i]
        // используется сдвиг SMAX, потому что могут быть отрицательные числа

        val p = Array(n) { IntArray(2 * SMAX) }

        d[0][SMAX + a[0]] = 1
        for (i in 0 until n - 1) {
            for (s in 0 until 2 * SMAX) {
                if (d[i][s] == 0) continue
                d[i + 1][s + a[i + 1]] += d[i][s]
                // последнее число нужно взять со знаком +
                p[i + 1][s + a[i + 1]] = 1
                d[i + 1][s - a[i + 1]] += d[i][s]
                // последнее число нужно взять со знаком -
                p[i + 1][s - a[i + 1]] = -1;
            }
        }
        recout(a, p, n - 1, SMAX + x);
        // Решение перебором
//        val s = CharArray(n - 1)
//        signsGenerator(s, charArrayOf('-', '+'), n - 1, 0, a, x)
    }
}

private fun PrintWriter.recout(a: IntArray, path: Array<IntArray>, i: Int, s: Int) {
    if (i > 0) {
        recout(a, path, i - 1, s - path[i][s] * a[i])
        if (path[i][s] == 1) {
            print('+')
        } else {
            print('-')
        }
    }
    print(a[i])
}

private fun signsGenerator(s: CharArray, chars: CharArray, n: Int, idx: Int, a: IntArray, x: Int) {
    if (idx == n) {
        val message = evalExpression(s, a, x)
        if (message != null) {
            println(message)
        }
        return
    }
    for (c in chars) {
        s[idx] = c
        signsGenerator(s, chars, n, idx + 1, a, x)
    }
}

private fun evalExpression(s: CharArray, a: IntArray, x: Int): String? {
    val builder = StringBuilder().append(a[0])
    var result = a[0]
    for (i in 1 until a.size) {
        builder.append(s[i-1]).append(a[i])
        when (s[i-1]) {
            '-' -> result -= a[i]
            '+' -> result += a[i]
        }
    }
    return if (x == result) {
        builder.append(" result ").append(result)
                .append(" is correct")
                .toString()
    } else {
        null
    }
}


/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/arithm2.in").inputStream()
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
