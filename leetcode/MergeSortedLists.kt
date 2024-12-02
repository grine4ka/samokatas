package leetcode

fun main() {
    val head = createList(listOf(1, 2))
    val head2 = createList(listOf(1, 3))

    val merged = mergeTwoLists(head, head2)
    printLinkedList(merged)

    println()
    println("-----------------------")
    val head3 = createList(listOf())
    val head4 = createList(listOf())
    val merged2 = mergeTwoLists(head3, head4)
    printLinkedList(merged2)

    println()
    println("-----------------------")
    val head5 = createList(listOf(1, 4, 5, 8))
    val head6 = createList(listOf(0, 9))
    val merged3 = mergeTwoLists(head5, head6)
    printLinkedList(merged3)


}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1
    var curr1 = list1
    var curr2 = list2
    val resultHead: ListNode
    if (curr1.`val` < curr2.`val`) {
        resultHead = curr1
        curr1 = curr1.next
    } else {
        resultHead = curr2
        curr2 = curr2.next
    }
    var resultCurr: ListNode? = resultHead
    while (resultCurr != null) {
        if (curr1 == null) {
            resultCurr.next = curr2
            resultCurr = resultCurr.next
            curr2 = curr2?.next
            continue
        }
        if (curr2 == null) {
            resultCurr.next = curr1
            resultCurr = resultCurr.next
            curr1 = curr1.next
            continue
        }
        val val1 = curr1.`val`
        val val2 = curr2.`val`
        if (val1 < val2) {
            resultCurr.next = curr1
            resultCurr = resultCurr.next
            curr1 = curr1.next
        } else {
            resultCurr.next = curr2
            resultCurr = resultCurr.next
            curr2 = curr2.next
        }
    }
    return resultHead
}