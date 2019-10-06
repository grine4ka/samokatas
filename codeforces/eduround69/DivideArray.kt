package eduround69

// https://codeforces.com/contest/1197/problem/B
fun main() {
    val (n, k) = readInts()
    val a = readInts().toIntArray()
    println("${solveProblem(n, k, a)}")
}

private fun solveProblem(n: Int, k: Int, a: IntArray): Int {
    val diffs = IntArray(n - 1) {
        a[it + 1] - a[it]
    }
    diffs.sort()
    return diffs.take(n - k).sum()
}

private fun readInts() = readLine()!!.split(" ").map(String::toInt)