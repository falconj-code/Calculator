package com.falconj.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ExpressionWriterTest {

    private lateinit var writer: ExpressionWriter

    @Before
    fun setUp() {
        writer = ExpressionWriter()
    }

    @Test
    fun `Parentheses parsed`() {
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Number(5))
        writer.processAction(CalculatorAction.Op(Operation.ADD))
        writer.processAction(CalculatorAction.Number(4))
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Op(Operation.MULTIPLY))
        writer.processAction(CalculatorAction.Number(2))
        writer.processAction(CalculatorAction.Parentheses)

        assertThat(writer.expression).isEqualTo("((5+4)x2)")
    }
}