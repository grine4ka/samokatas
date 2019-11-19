package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter

fun main() {
    output {
        val n = readInt()
        val iceCreams = mutableSetOf<String>()
        var cnt = 0
        repeat(n) {
            val iceCream = readLn()
            if (iceCreams.contains(iceCream)) {
                cnt++
                iceCreams.clear()
                iceCreams.add(iceCream)
            } else {
                iceCreams.add(iceCream)
            }
        }
        println("Minimum amount of ice cream producers is ${cnt + 1}")
    }
}

/** IO code start */
private val INPUT = File("stepik/sportprogramming/ice2.in").inputStream()
//@JvmField val OUTPUT = File("output.txt").outputStream()
//private val INPUT = System.`in`
private val OUTPUT = System.out

private val reader = INPUT.bufferedReader()
private fun readLine(): String? = reader.readLine()
private fun readLn() = reader.readLine()!!
private fun readInt() = readLn().toInt()
private fun readInts() = readLn().split(" ").map(String::toInt).toIntArray()

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) { writer.apply(block).flush() }

