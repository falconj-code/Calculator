package com.falconj.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `All properly parsed`() {
        parser = ExpressionParser("2.901+0.47+(6/3)-(5.8x2)")

        val actual = parser.parse()

        val expected = listOf(
            ExpressionPart.Number(2.901),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(0.47),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(6.0),
            ExpressionPart.Op(Operation.DIVIDE),
            ExpressionPart.Number(3.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(5.8),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(2.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing)
        )
        assertThat(expected).isEqualTo(actual)
    }
}