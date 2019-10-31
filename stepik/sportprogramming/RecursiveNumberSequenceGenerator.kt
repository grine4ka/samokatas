package stepik.sportprogramming

private var num = 0

fun main() {
    val n = readInt()
    val m = readInt()
    val a = IntArray(n) {0}
    rec(a, n, m, 0)
}

private fun rec(a: IntArray, n: Int, m: Int, idx: Int) {
    if (idx == n) {
        num++
        println("$num) " + a.joinToString())
        return
    }
    for (i in 1..m) {
        a[idx] = i
        rec(a, n, m, idx + 1)
    }
}

private fun readInt() = readLine()!!.toInt()
