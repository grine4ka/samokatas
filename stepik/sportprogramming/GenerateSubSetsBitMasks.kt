package stepik.sportprogramming

import java.io.PrintWriter
import java.util.*

fun main() {
    output {
        val n = readInt()
        val subsets = mutableListOf<Subset>()
        for (mask in 0 until (1 shl n)) {
            val subset = mutableListOf<Int>()
            for (i in 0 until n) {
                if (mask and (1 shl i) != 0) {
                    subset.add(i+1)
                }
            }
            subsets.add(Subset(subset))
        }
        subsets.sort()
        for (i in 1..subsets.size) {
            println("$i) ${subsets[i - 1].subset}")
        }
    }
}

private class Subset(val subset: List<Int>): Comparable<Subset> {

    override fun compareTo(other: Subset): Int {
        val length = minOf(this.subset.size, other.subset.size)
        for (i in 0 until length) {
            if (this.subset[i] < other.subset[i]) {
                return -1
            } else if (this.subset[i] > other.subset[i]) {
                return 1
            }
        }
        return other.subset.size - this.subset.size
    }

}

/** IO code start */
private val INPUT = System.`in`
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
