package codeforces.eduround69

import java.io.PrintWriter

// https://codeforces.com/contest/1197/problem/B
fun main() {
    bufferOut {
        val ans = solveProblem()
        println(if (ans) "YES" else "NO")
    }
}

private fun solveProblem(): Boolean {
    val n = readInt()
    val radiuses = readInts().toIntArray()
    var maxi = 0
    for (i in 0 until n) {
        if (radiuses[i] == n) {
            maxi = i
            break
        }
    }
    var ok = true
    for (i in 0 until maxi) {
        if (radiuses[i] > radiuses[i + 1]) {
            ok = false
            break
        }
    }
    if (!ok) return false
    for (i in maxi until n - 1) {
        if (radiuses[i] < radiuses[i+1]) {
            ok = false
            break
        }
    }
    return ok
}

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt)

private fun bufferOut(block: PrintWriter.() -> Unit) = PrintWriter(System.out).use { block(it) }