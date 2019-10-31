package stepik.sportprogramming

import java.util.*

private var braces: String = ""
private var stack: Deque<Char> = ArrayDeque()

fun main() {
    val n = readInt()
    repeat(n) {
        braces = readLine()!!
        stack = ArrayDeque()
        val ans = if (solution(0, braces.length - 1)) "" else "not"
        println("This sequence $braces is $ans correct")
    }
}

private fun solution(start: Int, end: Int): Boolean {
    for (i in start..end) {
        val current = braces[i]
        if (current == '(' || current == '[') {
            stack.addFirst(current)
        } else if (stack.isEmpty()) {
            return false
        } else {
            val last = stack.pop()
            val pair = last.toString() + current.toString()
            if (pair != "()" && pair != "[]") {
                return false
            }
        }
    }
    return stack.size == 0
}

private fun readInt() = readLine()!!.toInt()