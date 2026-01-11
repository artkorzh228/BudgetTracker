package budget.domain

import org.example.budget.cli.createTransaction
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
import java.time.Instant

class TransactionTest {
    @Test
    fun `should create transaction when data is valid`(){
        val transaction = createTransaction(
            amount = 500.0,
            category = "Salary",
        )

        assertEquals(500.0, transaction.amount)
        assertEquals("Salary", transaction.category)
    }

    @Test
    fun `should throw exception when amount is zero or negative`(){
        val exceptionZero = assertThrows<IllegalArgumentException> {
            createTransaction(amount = 0.0)
        }
        assertEquals(exceptionZero.message, "Amount must be positive.")

        val exceptionNegative = assertThrows<IllegalArgumentException> {
            createTransaction(amount = -1.0)
        }
        assertEquals(exceptionNegative.message, "Amount must be positive.")
    }

    @Test
    fun `should throw exception when category is blank`(){
        val exceptionBlank = assertThrows<IllegalArgumentException> {
            createTransaction(category = "")
        }
        assertEquals(exceptionBlank.message, "Category cannot be blank.")

        val exceptionSpace = assertThrows<IllegalArgumentException> {
            createTransaction(category = " ")
        }
        assertEquals(exceptionSpace.message, "Category cannot be blank.")
    }

    @Test
    fun `should throw exception when id is blank`(){
        val idSpace = assertThrows<IllegalArgumentException>{
            createTransaction(id = "  ")
        }
        assertEquals(idSpace.message, "ID cannot be blank.")
        val idBlanc = assertThrows<IllegalArgumentException>{
            createTransaction(id = "")
        }
        assertEquals(idBlanc.message, "ID cannot be blank.")
    }



}