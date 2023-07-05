package com.joew.calculator

import org.junit.Assert.*
import org.junit.Test
import java.lang.Error
import java.math.BigDecimal

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun testEvaluateExpressionBasicOperations() {
        assertEquals(BigDecimal("30"), calculator.evaluateExpression("10+10+10"))
        assertEquals(BigDecimal("25"), calculator.evaluateExpression("5X10/2"))
        assertEquals(BigDecimal("-10"), calculator.evaluateExpression("10-20"))
        assertEquals(BigDecimal("10"), calculator.evaluateExpression("10"))
    }

    @Test(expected = ArithmeticException::class)
    fun testEvaluateExpressionDivideBy0() {
        calculator.evaluateExpression("10/0")
    }
}