package stepik.sportprogramming

/**
 * Жадный алгоритм для решения задачи о размене не является оптимальным!!!
 */
private var sum: Int = 0
private var coins: IntArray = intArrayOf(10, 5, 2, 1)

fun main() {
    sum = readInt()
    coins = readInts()
    coins.sortDescending()
    println("Count will be ${count(coins, sum)}")
}

private fun count(coins: IntArray, sum: Int): Int {
    var varSum = sum
    var count = 0
    for (i in 0 until coins.size) {
        count += varSum / coins[i]
        varSum %= coins[i]
    }
    return count
}

private fun readInt() = readLine()!!.toInt()

private fun readInts() = readLine()!!.split(" ").map(String::toInt).toIntArray()
