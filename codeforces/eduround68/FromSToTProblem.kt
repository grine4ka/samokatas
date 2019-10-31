package codeforces.eduround68

import java.io.PrintWriter

// https://codeforces.com/contest/1194/problem/C
fun main() {
    val q = readInt()
    bufferOut {
        repeat(q) {
            val ans = solveProblem()
            println(if (ans) "YES" else "NO")
        }
    }
}

private fun solveProblem(): Boolean {
    val s = readLine()!!
    val t = readLine()!!
    val p = readLine()!!
    if (!t.hasSubsequenceOf(s)) return false
    val alphabet = IntArray(26)
    s.forEach {
        alphabet[it - 'a']++
    }
    p.forEach {
        alphabet[it - 'a']++
    }
    t.forEach {
        alphabet[it - 'a']--
        if (alphabet[it - 'a'] < 0) return false
    }
    return true
}

private fun String.hasSubsequenceOf(subs: String): Boolean {
    var j = 0
    forEach { c ->
        if (j < subs.length && c == subs[j]) j++
    }
    if (j == subs.length) return true
    return false
}

private fun readInt() = readLine()!!.toInt()
private fun bufferOut(block: PrintWriter.() -> Unit) = PrintWriter(System.out).use { block(it) }
