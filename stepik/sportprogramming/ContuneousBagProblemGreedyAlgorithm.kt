package stepik.sportprogramming

private val things = mutableListOf<Thing>()

fun main() {
    val (n, maxWeight) = readPair()
    repeat(n) {
        things.add(readThing())
    }
    println("Maximum value of all things is ${solution(maxWeight)}")
}

private fun solution(maxWeight: Int): Int {
    val sortedByValue = things.sortedDescending()
    var sum = 0
    var sumWeight: Int = maxWeight
    for (i in 0 until sortedByValue.size) {
        if (sumWeight <= 0) {
            break
        }
        val thing = sortedByValue[i]
        if (sumWeight >= thing.weight) {
            sumWeight -= thing.weight
            sum += thing.cost
        } else {
            sum += (sumWeight * thing.getValue())
            sumWeight -= thing.weight
        }
    }
    return sum
}

private class Thing(val weight: Int, val cost: Int) : Comparable<Thing> {

    override fun compareTo(other: Thing): Int {
        return getValue() - other.getValue()
    }

    fun getValue(): Int {
        return cost / weight
    }
}

private fun readPair(): Pair<Int, Int> {
    val conditions = readLine()!!.split(" ").map(String::toInt).toIntArray()
    return Pair(conditions[0], conditions[1])
}

private fun readThing(): Thing {
    val thing = readLine()!!.split(" ").map(String::toInt).toIntArray()
    return Thing(thing[0], thing[1])
}
