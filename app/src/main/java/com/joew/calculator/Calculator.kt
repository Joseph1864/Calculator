package com.joew.calculator

class Calculator {

    fun evaluateExpression(expression: String) : Double {
        if (expression.isEmpty()) return 0.0
        var total: Double = 0.0
        var operand1: String = ""
        var operand2: String = ""
        var operation: Int = 0
        var breakRecursion: Boolean = false

        for (i in expression.indices) {
            operand1 += expression[i]
            if (operation == 0 && i > 0 && (expression[i] == '+' || expression[i] == '-' || expression[i] == 'X' || expression[i] == '/')) {
                when(expression[i]) {
                    '+' -> operation = 1
                    '-' -> operation = 2
                    'X' -> operation = 3
                    '/' -> operation = 4
                }
                operand2 = operand1.dropLast(1)
                operand1 = ""
            } else if (operation == 0 && i == expression.length -1) {
                total += operand1.toDouble()
            } else if (operation != 0 && i == expression.length - 1) {
                when(operation) {
                    1 -> total = operand2.toDouble() + operand1.toDouble()
                    2 -> total = operand2.toDouble() - operand1.toDouble()
                    3 -> total = operand2.toDouble() * operand1.toDouble()
                    4 -> total = operand2.toDouble() / operand1.toDouble()
                }
            } else if (operation != 0 && (expression[i] == '+' || expression[i] == '-')) {
                when(operation) {
                    1 -> total = operand2.toDouble() + operand1.dropLast(1).toDouble()
                    2 -> total = operand2.toDouble() - operand1.dropLast(1).toDouble()
                    3 -> total = operand2.toDouble() * operand1.dropLast(1).toDouble()
                    4 -> total = operand2.toDouble() / operand1.dropLast(1).toDouble()
                }
                if (expression[i] == '+') {
                    operation = 1
                } else {
                    operation = 2
                }
                operand2 = total.toString()
                operand1 = ""
            } else if (operation != 0 && (expression[i] == 'X' || expression[i] == '/')) {
                when(operation) {
                    1 -> total += operand2.toDouble() + evaluateExpression(expression.drop(i - operand1.length))
                    2 -> total += operand2.toDouble() - evaluateExpression(expression.drop(i - operand1.length))
                    3 -> total += operand2.toDouble() * evaluateExpression(expression.drop(i - operand1.length))
                    4 -> total += operand2.toDouble() / evaluateExpression(expression.drop(i - operand1.length))
                }
                breakRecursion = true
            }
            if (breakRecursion) break
        }
        return total
    }
}
