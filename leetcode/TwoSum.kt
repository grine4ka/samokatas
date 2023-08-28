package ru.bykov.leetcode

/**
 * https://ru.bykov.leetcode.com/problems/two-sum/description/
 */
fun main(args: Array<String>) {

    val nums = intArrayOf(2, 7, 11, 15)

    print(twoSum(nums, 9).joinToString())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        val first = nums[i]
        for (j in i + 1 until nums.size) {
            val second = nums[j]
            val sum = first + second
            if (sum == target) {
                return intArrayOf(i, j)
            }
        }
    }
    throw IllegalArgumentException("No two sum solution")
}
