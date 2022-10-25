package com.falconj.calculator.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.falconj.calculator.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun test_1() {
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("()").performClick()
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("()").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("8").performClick()
        composeRule.onNodeWithText("÷").performClick()
        composeRule.onNodeWithText("4").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("5.0").assertIsDisplayed()
    }

    @Test
    fun test_2() {
        composeRule.onNodeWithText("()").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("7").performClick()
        composeRule.onNodeWithText("()").performClick()
        composeRule.onNodeWithText("%").performClick()
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("0").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("1.0").assertIsDisplayed()
    }

    @Test
    fun test_3() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("AC").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("6").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("9").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText(".").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("-17.3").assertIsDisplayed()
    }
}