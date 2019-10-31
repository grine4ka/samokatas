package stepik.sportprogramming

private var num: Int = 0
private var a: IntArray = intArrayOf()
private var n: Int = 0
private var m: Int = 0

fun main() {
    n = readInt()
    m = readInt()
    a = IntArray(n) {1}
    rec(0, 0)
}

private fun rec(idx: Int, count: Int) {
    if (count == m) {
        num++
        println("$num) " + a.joinToString(separator = "") { if (it == 0) "*" else "." })
        return
    }
    for (i in idx until n) {
        a[i] = 0
        rec(i + 2, count+1)
        a[i] = 1
    }
}

private fun readInt() = readLine()!!.toInt()
