package eduround69

import java.io.PrintWriter

// https://codeforces.com/contest/1197/problem/A
fun main() {
    val q = readInt()
    bufferOut {
        repeat(q) { solveQuery() }
    }
}

private fun PrintWriter.solveQuery() {
    val n = readInt()
    val lengths = readInts().sorted()
    val max2Index = lengths.size - 2
    if (lengths[max2Index] > lengths.size - 2) {
        println("${lengths.size - 2}")
    } else {
        println("${lengths[max2Index] - 1}")
    }
}

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt)

private fun bufferOut(block: PrintWriter.() -> Unit) = PrintWriter(System.out).use { block(it) }