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

        var minCompany = n
        var minMask = (1 shl n) - 1
        for (mask in 0 until (1 shl n)) {
            var acknowledged = 0
            for (i in 0 until n) {
                if (mask and (1 shl i) != 0) {
                    acknowledged = acknowledged or friends[i]
                }
            }
            if (acknowledged == (1 shl n) - 1) {
                val company = countOnes(mask, n)
                if (company < minCompany) {
                    minCompany = company
                    minMask = mask
                }
            }
        }
        println("Min company count is $minCompany")
        println("Min company mask is " + minMask.toString(2))
    }
}

private fun countOnes(number: Int, n: Int): Int {
    var count = 0
    for (i in 0 until n) {
        if (number and (1 shl i) != 0) {
            count++
        }
    }
    return count
}

/** IO code start */
private val INPUT = File("stepik/sportprogramming/new2.in").inputStream()
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
