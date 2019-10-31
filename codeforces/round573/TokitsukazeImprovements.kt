package codeforces.round573

// https://codeforces.com/contest/1191/problem/A

fun main(args: Array<String>) {
    val x = readLine()!!.toInt()

    val r = x % 4
    when (r) {
        // D increment by 1 to have A
        0 -> {
            println("1 A")
        }
        // A already the best
        1 -> {
            println("0 A")
        }
        // C increment by 1 to have B
        2 -> {
            println("1 B")
        }
        // B increment by 2 to have A
        3 -> println("2 A")
    }
}

