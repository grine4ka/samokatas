package ru.bykov.checks

fun main(args: Array<String>) {
    val categories = listOf(
        OperationCategory(1, "Category 1", OperationType.INCOMING),
        OperationCategory(2, "Category 2", OperationType.OUTGOING),
        OperationCategory(3, "Category 3", OperationType.INCOMING),
        OperationCategory(4, "Category 4", OperationType.OUTGOING),
        OperationCategory(5, "Category 5", OperationType.INCOMING),
        OperationCategory(6, "Category 6", OperationType.OUTGOING)
    )

    val map = categories.asSequence()
        .fold(
            HashMap<OperationType, MutableList<NewFilterItem>>()
        ) { acc, operationCategory ->
            if (acc.containsKey(operationCategory.operationType)) {
                acc[operationCategory.operationType]?.add(filterItem(operationCategory))
                acc
            } else {
                acc[operationCategory.operationType] = ArrayList<NewFilterItem>().apply {
                    add(filterItem(operationCategory))
                }
                acc
            }
        }

    print(map)
}

class OperationCategory(
    val id: Int,
    val name: String,
    val operationType: OperationType
)

enum class OperationType {

    INCOMING,
    OUTGOING

}

data class NewFilterItem(
    val id: Int,
    val name: String
)

fun filterItem(category: OperationCategory): NewFilterItem {
    return NewFilterItem(category.id, category.name)
}
