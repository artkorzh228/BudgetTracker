package org.example.budget.cli

import org.example.budget.domain.Transaction
import org.example.budget.domain.TransactionType
import java.time.Instant

fun main(){

}

fun createTransaction(
    id: String = "tx-123",
    type: TransactionType = TransactionType.INCOME,
    amount: Double = 100.0,
    category: String = "Food",
    timestamp: Instant = Instant.parse("2025-01-01T00:00:00Z"),
    note: String? = null
): Transaction {
    return Transaction(id, type, amount, category, timestamp, note)
}