package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val a = readIntArray(n)
        for (num in a) {
            print("${countOnes(num)} ")
        }
    }
}

private fun countOnes(number: Int): Int {
    var count = 0
    for (i in 0 until 32) {
        if (number and (1 shl i) != 0) {
            count++
        }
    }
    return count
}

/** IO code start */
private val INPUT = File("stepik/sportprogramming/ones.in").inputStream()
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
