package stepik.sportprogramming

private const val MAX_DAYS = 5000

private val used: BooleanArray = BooleanArray(MAX_DAYS) { false }
private val orders = mutableListOf<Order>()

fun main() {
    val n = readInt()
    repeat(n) {
        orders.add(readOrder())
    }
    val sortedByDeadlineOrders = orders.sortedDescending()
    var sum: Long = 0
    for (i in 0 until sortedByDeadlineOrders.size) {
        val order = sortedByDeadlineOrders[i]
        var k = order.deadline
        while (k >= 1 && used[k]) {
            k--
        }
        if (k == 0) {
            continue
        }
        used[k] = true
        sum += order.cost
    }
    println("Maximum sum of all orders will be $sum")
}

private class Order(val deadline: Int, val cost: Int) : Comparable<Order> {

    override fun compareTo(other: Order): Int {
        return cost - other.cost
    }
}

private fun readInt() = readLine()!!.toInt()

private fun readOrder(): Order {
    val pairOfInts = readLine()!!.split(" ").map(String::toInt).toIntArray()
    return Order(pairOfInts[0], pairOfInts[1])
}
