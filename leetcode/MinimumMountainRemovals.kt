package leetcode

// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
fun main() {
    val arr = intArrayOf(1, 3, 1)
    minimumMountainRemovals(arr)

    val arr1 = intArrayOf(2, 1, 1, 5, 6, 2, 3, 1)
    minimumMountainRemovals(arr1)
}

fun minimumMountainRemovals(nums: IntArray): Int {
    val maxIndex = nums.maxIndex()
    require(maxIndex != 0)
    val potentialSortedAsc = nums.slice(0..maxIndex - 1)
    val potentialSortedDesc = nums.slice(maxIndex + 1..nums.lastIndex)
    println("Sorted asc: $potentialSortedAsc")
    println("Sorted desc: $potentialSortedDesc")
    return 0
}

fun IntArray.maxIndex(): Int {
    var maxIndex = 0
    var max = this[maxIndex]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) {
            max = e
            maxIndex = i
        }
    }
    return maxIndex
}