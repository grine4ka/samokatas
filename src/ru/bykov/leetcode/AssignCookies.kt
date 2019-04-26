package ru.bykov.leetcode

/**
 * https://ru.bykov.leetcode.com/problems/assign-cookies/
 */
fun main(args: Array<String>) {

    val assignCookies = AssignCookies()

    println(assignCookies.findContentChildren(
            intArrayOf(1,2,3), intArrayOf(1,1)
    ))

    println(assignCookies.findContentChildren(
            intArrayOf(1,2), intArrayOf(1,2,3)
    ))

    println(assignCookies.findContentChildren(
            intArrayOf(10,9,8,7), intArrayOf(10,9,8,7)
    ))
}

class AssignCookies {

    // my decision
    fun myFindContentChildren(g: IntArray, s: IntArray): Int {
        val diff = g.size - s.size
        val newGreeds = if (diff > 0) {
            g.sorted().toMutableList().dropLast(diff)
        } else {
            g.sorted().toMutableList()
        }
        val cookies = s.sorted().toMutableList()
        var contented = 0
        newGreeds.forEach { greed ->
            val iterator = cookies.listIterator()
            var found = false
            while (iterator.hasNext()) {
                found = iterator.next() >= greed
                if (found) {
                    contented = contented.inc()
                    iterator.remove()
                    break
                }
            }
            if (!found) {
                return@forEach
            }
        }
        return contented
    }

    // shorter one
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var i = 0
        var j = 0
        var op = 0
        while (i < g.size && j < s.size) {
            if (g[i] <= s[j]) {
                op++
                i++
                j++
            }
            else {
                j++
            }
        }
        return op
    }
}