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

private fun rec(idx: Int) {
    if (idx == n - 1) {
        val count = count()
        println("For permutation " + p.joinToString(prefix = "{", postfix = "}") + " , answer is $count")
        ans = minOf(ans, count)
        return
    }
    for (i in 1 until n) {
        if (used[i]) continue
        p[idx] = i
        used[i] = true
        rec(idx + 1)
        used[i] = false
    }
}

private fun count(): Int {
    var sum = 0
    for (i in 0 until n) {
        val nodeCur = p[i]
        val nodePrev = if (i == 0) 0 else p[i - 1]
        sum += a[nodePrev][nodeCur]
    }
    return sum
}

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt).toIntArray()
