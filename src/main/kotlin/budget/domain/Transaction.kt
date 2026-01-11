package org.example.budget.domain

import java.time.Instant

class Transaction(
    val id: String,
    val type: TransactionType,
    val amount: Double,
    val category: String,
    val timestamp: Instant,
    val note: String?,
) {
    init {
        require(amount > 0) { "Amount must be positive." }
        require(category.isNotBlank()) { "Category cannot be blank." }
        require(id.isNotBlank()) { "ID cannot be blank." }
    }
}