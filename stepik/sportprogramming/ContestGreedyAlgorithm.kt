package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter

fun main() {
    output {
        val (n, t) = readInts()
        val tasks = readInts()
        tasks.sort()
        var time = 0
        var fines = 0
        var cnt = 0
        for (i in 0 until n) {
            if (time + tasks[i] <= t) {
                cnt++
                time += tasks[i]
                fines += time
            } else {
                break
            }
        }
        println("Maximum amount of tasks is $cnt. And optimum fine time is $fines")
    }
}

/** IO code start */
private val INPUT = File("stepik/sportprogramming/contest.in").inputStream()
//@JvmField val OUTPUT = File("output.txt").outputStream()
//private val INPUT = System.`in`
private val OUTPUT = System.out

private val reader = INPUT.bufferedReader()
private fun readLine(): String? = reader.readLine()
private fun readLn() = reader.readLine()!!
private fun readInts() = readLn().split(" ").map(String::toInt).toIntArray()

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) { writer.apply(block).flush() }

