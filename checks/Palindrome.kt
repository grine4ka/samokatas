package checks

fun main() {
    println("Palindrome check")


    assert(Palindrome.isPalindrome(""))
    assert(Palindrome.isPalindrome("a"))
    assert(Palindrome.isPalindrome("asdf fdsa"))
    val value = Palindrome.isPalindrome("asfasdfa")
    println("'asfasdfa' is $value")
    assert(value)
}

object Palindrome {

    // "asdf fdsa"
    // ""
    // "a"
    // "asfasdfa"
    fun isPalindrome(word: String): Boolean {
        val length = word.length
        if (length == 0 || length == 1) return true

        val midIndex = length / 2
        // "asdf fdsa"
        for (i in 0 until midIndex) {
            if (word[i] != word[length - 1 - i]) return false
        }
        return true
    }
}
