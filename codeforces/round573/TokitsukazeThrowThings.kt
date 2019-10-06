package round573

// https://codeforces.com/contest/1191/problem/C

fun main(args: Array<String>) {
    val (n, m1, k) = readLongs()
    val m = m1.toInt()

    val p = readLongs().toLongArray()

    var step = 0
    // removed и sum можно объединить
    var removed = 0
    var sum = 0

    while (removed < m) {
        // первая страница, на которой встречается элемент для удаления
        val pageIndex = ((p[removed] - sum - 1) / k) + 1
        // максимальный элемент на странице
        val maxElemPage = pageIndex * k + sum
        // идем по массиву удаляемых элементов до тех пор пока они меньше либо равны максимального на странице
        while (removed < m && p[removed] <= maxElemPage) {
            removed++
            sum++
        }
        step++
    }
    println("$step")
}

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt)

private fun readLong() = readLine()!!.toLong()

private fun readLongs() = readLine()!!.split(" ").map(String::toLong)