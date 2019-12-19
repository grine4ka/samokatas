package ru.bykov.stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val m = readInt()
        val array = Array(n) {
            readIntArray(m)
        }
        val d = Array(n) { IntArray(m) }
        val path = Array(n) { IntArray(m) }
        println(solution(array, d, path))
        recout(path, n - 1, m - 1)
    }
}

private fun PrintWriter.recout(path: Array<IntArray>, i: Int, j: Int) {
    if (i == 0 && j == 0) {
        return
    }
    if (path[i][j] == 0) {
        recout(path, i - 1, j)
        print('D')
    }
    if (path[i][j] == 1) {
        recout(path, i, j - 1)
        print('R')
    }
}

private fun solution(array: Array<IntArray>, d: Array<IntArray>, path: Array<IntArray>): String {
    for (i in 0 until array.size) {
        for (j in 0 until array[i].size) {
            d[i][j] = array[i][j]
            if (i > 0 && d[i - 1][j] + array[i][j] > d[i][j]) {
                d[i][j] = d[i - 1][j] + array[i][j]
                path[i][j] = 0
            }
            if (j > 0 && d[i][j - 1] + array[i][j] > d[i][j]) {
                d[i][j] = d[i][j - 1] + array[i][j]
                path[i][j] = 1
            }
        }
    }
    val n = array.size
    val m = array[0].size
    return d[n - 1][m - 1].toString()
}

/** IO code start */
//private val INPUT = System.`in`
private val INPUT = File("stepik/sportprogramming/bug2.in").inputStream()
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
