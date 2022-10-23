package com.falconj.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionEvaluatorTest {

    private lateinit var evaluator: ExpressionEvaluator

    @Test
    fun `All properly tested`() {
        evaluator = ExpressionEvaluator(
            listOf(
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
        )
        assertThat(evaluator.evaluate()).isEqualTo(-6.229)
    }
}










