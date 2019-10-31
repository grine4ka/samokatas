package stepik.sportprogramming

private var num = 0
private var n: Int = 0
private var s: CharArray = charArrayOf()

fun main() {
    n = readInt()
    s = CharArray(2 * n) { ' ' }
    rec(0, 0)
}

private fun rec(idx: Int, bal: Int) {
    if (idx == 2 * n) {
        if (bal == 0) {
            num++
            println("$num) " + s.joinToString(separator = ""))
        }
        return
    }
    if (bal < n) {
        s[idx] = '('
        rec(idx + 1, bal + 1)
    }
    if (bal > 0) {
        s[idx] = ')'
        rec(idx + 1, bal - 1)
    }
}

private fun readInt() = readLine()!!.toInt()
