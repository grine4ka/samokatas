package ru.bykov.stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.lang.Integer.max
import java.util.*
import kotlin.math.max

fun main() {
    output {
        val n = readInt()
        val array = readIntArray(n)
        val d = IntArray(n)
        val c = LongArray(n)
        val path = IntArray(n)
        val solution = solution(array, d, c, path)
        println("Length of LIS is ${solution.first}")
        println("LIS certificate is ")
        recout(path, array, solution.second)
        println()
        println("LIS count is ${solution.third}")
    }
}

private fun PrintWriter.recout(path: IntArray, array: IntArray, i: Int) {
    if (i < 0) return
    recout(path, array, path[i])
    print(array[i])
    print(" ")
}

private fun solution(array: IntArray, d: IntArray, c: LongArray, path: IntArray): Triple<Int, Int, Long> {
    for (i in 0 until array.size) {
        c[i] = 1
        d[i] = 1
        path[i] = -1
        for (j in 0 until i) {
            if (array[j] < array[i]) {
                if (d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1
                    c[i] = c[j]
                    path[i] = j
                } else if (d[j] + 1 == d[i]) {
                    c[i] += c[j]
                }
            }
        }
    }
    var pos = 0
    var length = d[0]
    for (i in 0 until d.size) {
        if (d[i] > length) {
            pos = i
            length = d[i]
        }
    }
    var sum = 0L
    for (i in 0 until c.size) {
        if (d[i] == length) {
            sum += c[i]
        }
    }
    return Triple(length, pos, sum)
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/lis.in").inputStream()
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
