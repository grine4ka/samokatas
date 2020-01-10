package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*
import kotlin.math.abs

fun main() {
    output {
        val n = readInt()
        val shops = readLongArray(n).sorted()
        val stores = readLongArray(n).sorted()
        val sum = shops.zip(stores).map { abs(it.first - it.second) }.sum()
        println("Minimum summary distance is $sum")
    }
}

/** IO code start */
private val INPUT = File("stepik/sportprogramming/shops2.in").inputStream()
//private val INPUT = System.`in`
private val OUTPUT = System.out

private val reader = INPUT.bufferedReader()
private var tokenizer: StringTokenizer = StringTokenizer("")
private fun read(): String {
    if (tokenizer.hasMoreTokens().not()) {
        tokenizer = StringTokenizer(reader.readLine() ?: return "", " ")
    }
    return tokenizer.nextToken()
}

private fun readLine(): String? = reader.readLine()
private fun readLn() = reader.readLine()!!
private fun readInt() = readLn().toInt()
private fun readLongArray(n: Int) = LongArray(n) { read().toLong() }

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) { writer.apply(block).flush() }

