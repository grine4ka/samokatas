package ru.bykov.checks

fun main() {
    val map = mutableMapOf(
        "name" to "John",
        "age" to 25
    )
    val user = User(map)
    println(user.name)
    println(user.age)
}

class User(
    val map: Map<String, Any?>
) {

    val name: String by map
    val age: Int by map
}