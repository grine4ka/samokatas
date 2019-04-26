package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/my-calendar-i/
 */
fun main(args: Array<String>) {

    val calendar = MyCalendar()

    println(calendar.book(10, 20))
    println(calendar.book(15, 25))
    println(calendar.book(20, 30))
}

class MyCalendar {

//    private val events = HashSet<Event>()

    private val calendar = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        val prev = calendar.floorKey(start)
        val next = calendar.ceilingKey(start)
        if (prev != null && calendar[prev]!! > start) {
            return false
        }
        if (next != null && end > next) {
            return false
        }
        calendar[start] = end
        return true
//        return events.add(Event(start, end))
    }

}

class Event(
        val start: Int,
        val end: Int
) : Comparable<Event> {

    override fun compareTo(other: Event): Int {
        return if (start < other.end && end > other.start) {
            0
        } else {
            start - other.start
        }
    }
}