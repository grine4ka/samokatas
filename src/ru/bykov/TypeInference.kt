package ru.bykov

fun main(args: Array<String>) {
    val map = mutableMapOf(
        "foo" to "bar",
        "name" to "John"
    )
    val nameFromMap = NameFromMap(map)
    println(nameFromMap.name)
}

class NameFromMap(
    map: MutableMap<String, out String>
) {

    val name: String by map
}