package stepik.sportprogramming

import java.io.File
import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val m = readInt()
        val friends = IntArray(n) {
            (1 shl it)
        }
        repeat(m) {
            val f1 = readInt()
            val f2 = readInt()
            friends[f1 - 1] = friends[f1 - 1] or (1 shl (f2 - 1))
            friends[f2 - 1] = friends[f2 - 1] or (1 shl (f1 - 1))
        }
        println(friends.joinToString())
        var maxCompany = 0
        var maxMask = 0
        for (mask in 0 until (1 shl n)) {
            var companyCount = 0
            for (i in 0 until n) {
                if (mask and (1 shl i) != 0) {
                    if ((friends[i] and mask) == mask) {
                        companyCount++
                    }
                }
            }
            if (companyCount > maxCompany) {
                maxCompany = companyCount
                maxMask = mask
            }
        }
        println("Max company count is $maxCompany")
        println("Max company mask is " + maxMask.toString(2))
    }
}

/** IO code start */
private val INPUT = File("stepik/sportprogramming/friends2.in").inputStream()
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
