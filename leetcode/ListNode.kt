package leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// Вспомогательные функции
fun createList(list: List<Int>): ListNode? {
    if (list.isEmpty()) return null
    val head = ListNode(list[0])
    var curr = head
    for (i in 1 until list.size) {
        val node = ListNode(list[i])
        curr.next = node
        curr = node
    }
    return head
}

fun printLinkedList(head: ListNode?) {
    if (head == null) println("Empty list")
    var curr = head
    while (curr != null) {
        print("[${curr.`val`}]")
        curr = curr.next
        if (curr != null) print(" -> ")
    }
}
