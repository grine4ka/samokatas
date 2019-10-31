package stepik.sportprogramming

private var num = 0

fun main() {
    val n = readInt()
    val a = IntArray(n) {0}
    rec(a, n, 0, 0, 1)
}

private fun rec(a: IntArray, n: Int, idx: Int, sum: Int, last: Int) {
    if (sum == n) {
        num++
        println("$num) " + a.slice(IntRange(0, idx - 1)).joinToString("+"))
        return
    }
    for (i in last..n-sum) {
        a[idx] = i
        rec(a, n, idx + 1, sum + i, i)
    }
}

private fun readInt() = readLine()!!.toInt()
