package stepik.sportprogramming

private var a: Array<IntArray> = emptyArray()
private var ans: Int = Int.MAX_VALUE
private var ansPerm: String = ""
private var p: IntArray = intArrayOf()
private var used: BooleanArray = booleanArrayOf()
private var n: Int = 0

fun main() {
    n = readInt()
    a = Array(n) {
        readInts()
    }
    p = IntArray(n) { 0 }
    used = BooleanArray(n) { false }
    p[0] = 0
    recNew(1, 0)
    println("The shortest path is $ansPerm with value $ans")
}

private fun recNew(idx: Int, len: Int) {
    if (len >= ans) {
        return
    }
    if (idx == n) {
        val length = len + a[p[idx - 1]][0]
        if (length < ans) {
            ansPerm = p.joinToString(prefix = "{", postfix = "}")
            ans = length
        }
        return
    }
    for (i in 1 until n) {
        if (used[i]) continue
        p[idx] = i
        used[i] = true
        recNew(idx + 1, len + a[p[idx - 1]][i])
        used[i] = false
    }
}

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt).toIntArray()
