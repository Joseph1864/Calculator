package com.joew.calculator

import org.junit.Assert.*
import org.junit.Test
import java.lang.NumberFormatException
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

    @Test
    fun testEvaluateExpressionComplexOperations() {
        assertEquals(BigDecimal("11111111110"), calculator.evaluateExpression("10+100+1000+10000+100000+1000000+10000000+100000000+1000000000+10000000000"))
        assertEquals(BigDecimal("-98980.0"), calculator.evaluateExpression("840+26080/800X4300-240000"))
        assertEquals(BigDecimal("10"), calculator.evaluateExpression("4--6"))
        assertEquals(BigDecimal("-30"), calculator.evaluateExpression("5X-6"))
    }

    @Test(expected = ArithmeticException::class)
    fun testEvaluateExpressionDivideBy0() {
        calculator.evaluateExpression("10/0")
    }

    @Test(expected = NumberFormatException::class)
    fun testEvaluateExpressionDecimalError() {
        calculator.evaluateExpression("13.0.0")
    }
}