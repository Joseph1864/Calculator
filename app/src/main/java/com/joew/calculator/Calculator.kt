package com.joew.calculator

import java.math.BigDecimal
import java.math.MathContext

class Calculator {

    private val mathContext = MathContext(20)

    fun evaluateExpression(expression: String) : BigDecimal {
        if (expression.contains('+')) {
            return with(expression) { evaluateExpression(substringBefore('+'))
                    .plus(evaluateExpression(substringAfter('+')))
            }
        }
        if (expression.contains('-')) {
            expression.forEachIndexed { index, c ->
                if (index > 0 && c == '-' && expression[index - 1].isDigit()) {
                    return with(expression) {evaluateExpression(substring(0, index))
                        .minus(evaluateExpression(substring(index + 1)))
                    }
                }
            }
        }
        if (expression.contains('X')) {
            return with(expression) {
                evaluateExpression(substringBefore('X'))
                    .multiply(evaluateExpression(substringAfter('X')), mathContext)
            }
        }
        if (expression.contains('/')) {
            return with(expression) {
                evaluateExpression(substringBefore('/'))
                    .divide(evaluateExpression(substringAfter('/')), mathContext)
            }
        }
        return expression.trim().toBigDecimal()
    }
}
