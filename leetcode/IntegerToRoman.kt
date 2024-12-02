package leetcode

// https://leetcode.com/problems/integer-to-roman/
fun main() {

    val num = 3749
    println("$num in Roman will be ${intToRoman(num)}")

    val num2 = 4
    println("$num2 in Roman will be ${intToRoman(num2)}")

    val num3 = 58
    println("$num3 in Roman will be ${intToRoman(num3)}")

    val num4 = 1994
    println("$num4 in Roman will be ${intToRoman(num4)}")
}

fun intToRomanMap(num: Int): String {
    // Dictionary represents roman and numerals as a set of key-values
    val romanNumerals = mapOf(
        "M" to 1000,
        "CM" to 900,
        "D" to 500,
        "CD" to 400,
        "C" to 100,
        "XC" to 90,
        "L" to 50,
        "XL" to 40,
        "X" to 10,
        "IX" to 9,
        "V" to 5,
        "IV" to 4,
        "I" to 1
    )

    // Number which is converted to a roman numeral
    var remainNumber = num

    val result = buildString {
        // Iterates through the key-value pairs in the romanNumberals dictionary
        for((roman, numeral) in romanNumerals) {
            // Check if the remainNumber is greater than or equal to the value of the current numeral.
            while(remainNumber >= numeral) {
                append(roman)
                remainNumber -= numeral
            }
        }
    }

    return result
}

fun intToRoman(num: Int): String {
    var result = ""
    val numStr = num.toString().toCharArray()
    for (i in numStr.indices) {
        val powerPosition = numStr.size - i
        when (powerPosition) {
            1 -> { // 1 to 9
                when (numStr[i]) {
                    '1' -> result += "I"
                    '2' -> result += "II"
                    '3' -> result += "III"
                    '4' -> result += "IV"
                    '5' -> result += "V"
                    '6' -> result += "VI"
                    '7' -> result += "VII"
                    '8' -> result += "VIII"
                    '9' -> result += "IX"
                }
            }
            2 -> { // 1x to 9x
                when (numStr[i]) {
                    '1' -> result += "X"
                    '2' -> result += "XX"
                    '3' -> result += "XXX"
                    '4' -> result += "XL"
                    '5' -> result += "L"
                    '6' -> result += "LX"
                    '7' -> result += "LXX"
                    '8' -> result += "LXXX"
                    '9' -> result += "XC"
                }
            }
            3 -> { // 1xx to 9xx
                when (numStr[i]) {
                    '1' -> result += "C"
                    '2' -> result += "CC"
                    '3' -> result += "CCC"
                    '4' -> result += "CD"
                    '5' -> result += "D"
                    '6' -> result += "DC"
                    '7' -> result += "DCC"
                    '8' -> result += "DCCC"
                    '9' -> result += "CM"
                }
            }
            4 -> { // 1xxx to 3xxx
                when (numStr[i]) {
                    '1' -> result += "M"
                    '2' -> result += "MM"
                    '3' -> result += "MMM"
                }
            }
        }
    }
    return result
}
