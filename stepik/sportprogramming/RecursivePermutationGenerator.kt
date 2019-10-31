package stepik.sportprogramming

private var num = 0

fun main() {
    val n = readInt()
    val a = IntArray(n) { 0 }
    val used = BooleanArray(n + 1) { false }
    rec(a, used, n, 0)
}

private fun rec(a: IntArray, used: BooleanArray, n: Int, idx: Int) {
    if (idx == n) {
        num++
        println("$num) " + a.joinToString())
        return
    }
    for (i in 1..n) {
        if (used[i]) continue
        a[idx] = i
        used[i] = true
        rec(a, used, n, idx + 1)
        used[i] = false
    }
}

private fun readInt() = readLine()!!.toInt()
