package stepik.sportprogramming

import java.util.*

private var num: Int = 0
private var n: Int = 0
private var s: CharArray = charArrayOf()
private val stack: Deque<Char> = ArrayDeque()

fun main() {
    n = readInt()
    s = CharArray(2 * n) { ' ' }
    rec(0, 0, 0)
}

private fun rec(idx: Int, bal1: Int, bal2: Int) {
    if (idx == 2 * n) {
        if (bal1 == 0 && bal2 == 0 && correct()) {
            num++
            println("$num) " + s.joinToString(separator = ""))
        }
        return
    }
    for (c in "()[]") {
        when (c) {
            '(' -> {
                if (bal1 + bal2 < n) {
                    s[idx] = c
                    rec(idx + 1, bal1 + 1, bal2)
                }
            }
            ')' -> {
                if (bal1 > 0) {
                    s[idx] = c
                    rec(idx + 1, bal1 - 1, bal2)
                }
            }
            '[' -> {
                if (bal1 + bal2 < n) {
                    s[idx] = c
                    rec(idx + 1, bal1, bal2 + 1)
                }
            }
            ']' -> {
                if (bal2 > 0) {
                    s[idx] = c
                    rec(idx + 1, bal1, bal2 - 1)
                }
            }
            else -> throw RuntimeException()
        }
    }
}

private fun correct(): Boolean {
    stack.clear()
    for (i in 0 until s.size) {
        val current = s[i]
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
    return stack.isEmpty()
}

private fun readInt() = readLine()!!.toInt()
