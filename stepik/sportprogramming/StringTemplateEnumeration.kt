package stepik.sportprogramming

import java.io.PrintWriter
import java.util.*

private var num = 0

fun main() {
    val template = readLn()
    val alphabet = charArrayOf('a', 'b', 'c', 'd', 'e')
    val positions = template
            .asSequence()
            .mapIndexed { index: Int, c: Char -> Pair(index, c) }
            .filter { it.second == '?' }
            .map { it.first }
            .toList()
    generate(template.toCharArray(), alphabet, positions, 0)
}

private fun generate(template: CharArray, alphabet: CharArray, positions: List<Int>, idx: Int) {
    if (idx == positions.size) {
        num++
        if (num == 5151)
            println("$num) ${template.joinToString("")}")
        return
    }
    for (j in 0 until alphabet.size) {
        template[positions[idx]] = alphabet[j]
        generate(template, alphabet, positions, idx + 1)
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

private fun readLn() = reader.readLine()!!
private fun readInt() = read().toInt()
private fun readIntArray(n: Int) = IntArray(n) { read().toInt() }

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) {
    writer.apply(block).flush()
}
