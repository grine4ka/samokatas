package eduround68

// https://codeforces.com/contest/1194/problem/A
fun main(args: Array<String>) {
    val n = readInt()
    val result = mutableListOf<Long>()
    for (i in 0 until n) {
        val (_, x) = readLongs()
        result.add(x*2)
    }
    result.forEach {
        println("$it")
    }
}

private fun readLong() = readLine()!!.toLong()

private fun readLongs() = readLine()!!.split(" ").map(String::toLong)

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt)
