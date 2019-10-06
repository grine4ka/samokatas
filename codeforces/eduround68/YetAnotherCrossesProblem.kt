package eduround68

import java.io.PrintWriter
import kotlin.math.min

// https://codeforces.com/contest/1194/problem/B
// this is mine
//fun eduround68.eduround68.eduround68.round567.round567.round573.eduround69.main(args: Array<String>) {
//    val q = eduround68.readInt()
//    val matrices = mutableListOf<Matrix>()
//    for (i in 0 until q) {
//        val (n, m) = eduround68.readInts()
//        val matrix = Matrix(n, m)
//        for (j in 0 until n) {
//            matrix.fillRow(j, readLine()!!)
//        }
//        matrices.add(matrix)
//    }
//    matrices.forEach {
//        println("${it.findMinMinutesForCrosses()}")
//    }
//}
//
//class Matrix(val n: Int, val m: Int) {
//
//    private val body = Array(n) {
//        IntArray(m)
//    }
//
//    private val tbody = Array(m) {
//        IntArray(n)
//    }
//
//    fun fillRow(row: Int, symbols: String) {
//        val r = body[row]
//        symbols.forEachIndexed { index, c ->
//            r[index] = if (c == '*') 1 else 0
//            tbody[index][row] = if (c == '*') 1 else 0
//        }
//    }
//
//    fun findMinMinutesForCrosses(): Int {
//        var minSum = Int.MAX_VALUE
//        for (i in 0 until n) {
//            val rowSum = m - body[i].sum()
//            for (j in 0 until m) {
//                val colSum = n - tbody[j].sum()
//                val sub = 1 - body[i][j]
//                val sum = rowSum + colSum - sub
//                if (sum < minSum) {
//                    minSum = sum
//                }
//            }
//        }
//        return minSum
//    }
//}

// this is elizarov's
fun main() {
    val q = readInt()
    bufferOut {
        repeat(q) { solveQuery() }
    }
}

private fun PrintWriter.solveQuery() {
    val (n, m) = readInts()
    val a = Array(n) { readLine()!!.map { it == '*' }.toBooleanArray() }
    val rowSums = IntArray(n)
    val colSums = IntArray(m)
    for (i in 0 until n) {
        for(j in 0 until m) {
            if (a[i][j]) {
                rowSums[i]++
                colSums[j]++
            }
        }
    }
    if (rowSums.any { it == m } && colSums.any { it == n }) {
        println(0)
        return
    }
    var ans = Int.MAX_VALUE
    for (i in 0 until n) {
        for(j in 0 until m) {
            var d = n + m - rowSums[i] - colSums[j]
            if (!a[i][j]) d--
            ans = min(ans, d)
        }
    }
    println(ans)
}

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt)

// for the future
private fun bufferOut(block: PrintWriter.() -> Unit) = PrintWriter(System.out).use { block(it) }