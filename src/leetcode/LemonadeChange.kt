package leetcode

/**
 * https://leetcode.com/problems/lemonade-change/description/
 */
fun main(args: Array<String>) {

    val bills = intArrayOf(5, 5, 10, 10, 20)

    println(lemonadeChange(bills))
}

fun lemonadeChange(bills: IntArray): Boolean {
    val lemonadeChange = LemonadeChange()
    bills.forEach {
        if (!lemonadeChange.change(it)) return false
    }
    return true
}

class LemonadeChange {

    private var fives: Int = 0
    private var tens: Int = 0

    fun change(bill: Int): Boolean {
        when (bill) {
            5 -> fives++
            10 -> {
                if (fives == 0) return false
                fives--
                tens++
            }
            20 -> {
                if (fives > 0 && tens > 0) {
                    fives--
                    tens--
                } else if (fives >= 3) {
                    fives -= 3
                } else {
                    return false
                }
            }
        }
        return true
    }
}
