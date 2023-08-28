package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
fun main(args: Array<String>) {

//    val str = "()[]{}"
    val str = "]"
    println(ValidParantheses().isValid(str))
}

private class ValidParantheses {
    fun isValid(str: String): Boolean {
        val stack = ArrayDeque<Char>()
        str.forEach { char ->
            when (char) {
                '(', '{', '[' -> {
                    println("Putting on a stack. $char")
                    stack.push(char)
                }
                ')' -> {
                    println("Popping from a stack. $char")
                    if (stack.isEmpty() || stack.pop() != '(') return false
                }
                '}' -> {
                    println("Popping from a stack. $char")
                    if (stack.isEmpty() || stack.pop() != '{') return false
                }
                ']' -> {
                    println("Popping from a stack. $char")
                    if (stack.isEmpty() || stack.pop() != '[') return false
                }
            }
        }
        return stack.isEmpty()
    }
}