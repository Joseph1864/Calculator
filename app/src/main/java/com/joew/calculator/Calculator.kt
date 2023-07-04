package com.joew.calculator

import java.math.BigDecimal
import java.math.MathContext

class Calculator {

    private val mathContext = MathContext(10)

    fun evaluateExpression(expression: String) : BigDecimal  = when {
        expression.contains('+') -> with(expression) {
            evaluateExpression(substringBefore('+'))
                .plus(evaluateExpression(substringAfter('+')))
        }
        expression.contains('-') -> with(expression) {
            evaluateExpression(substringBefore('-'))
                .minus(evaluateExpression(substringAfter('-')))
        }
        expression.contains('X') -> with(expression) {
            evaluateExpression(substringBefore('X'))
                .multiply(evaluateExpression(substringAfter('X')), mathContext)
        }
        expression.contains('/') -> with(expression) {
            evaluateExpression(substringBefore('/'))
                .divide(evaluateExpression(substringAfter('/')), mathContext)
        }
        else -> expression.trim().toBigDecimal()
    }
}
