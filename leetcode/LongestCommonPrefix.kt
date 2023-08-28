package leetcode

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
fun main(args: Array<String>) {

    val strs: Array<String> = arrayOf("flower", "flow", "flight")
//    val strs: Array<String> = arrayOf("dog","racecar","car")

    println(LongestCommonPrefix().longestCommonPrefix(strs))
}

private class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val shortestWord = strs.minBy { it.length }!!

        repeat(shortestWord.length) {
            for (j in strs.indices) {
                val str = strs[j]
                if (str[it] == shortestWord[it]) continue
                else return shortestWord.substring(0, it)
            }
        }
        return shortestWord
    }
}