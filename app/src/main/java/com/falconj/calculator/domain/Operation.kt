package com.falconj.calculator.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('x'),
    DIVIDE('/'),
}

val operationSymbols = Operation.values().map { it.symbol }.joinToString("")

fun operationFromSymbol(symbol: Char): Operation{
    return Operation.values().find { it.symbol == symbol }
        ?: throw IllegalArgumentException("Invalid symbol")
}