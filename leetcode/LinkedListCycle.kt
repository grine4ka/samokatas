package leetcode

// https://leetcode.com/problems/linked-list-cycle/
fun main() {
    val head = createList(listOf(3, 2, 0, -4))
    printLinkedList(head)
}

fun hasCycle(head: ListNode?): Boolean {
    val nodeSet = hashSetOf<ListNode>()
    var curr = head
    while (curr != null) {
        val added = nodeSet.add(curr)
        if (added.not()) return true
        curr = curr.next
    }
    return false
}

fun ListNode.getTail(): ListNode? {
    var curr: ListNode? = this
    while (curr?.next != null) {
        curr = curr.next
    }
    return curr
}