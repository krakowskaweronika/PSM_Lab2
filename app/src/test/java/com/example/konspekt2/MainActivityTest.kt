package com.example.konspekt2

import org.junit.Assert.assertEquals
import org.junit.Test

class LogicTest {

    @Test
    fun testConversions() {
        assertEquals(100.0, convertMetersToUnit("1", LengthUnit.CENTIMETER)!!, 0.0001)
        assertEquals(0.001, convertMetersToUnit("1", LengthUnit.KILOMETER)!!, 0.0001)

        assertEquals(0.00062137, convertMetersToUnit("1", LengthUnit.MILE)!!, 0.000001)

        assertEquals(1.057e-16, convertMetersToUnit("1", LengthUnit.LIGHT_YEAR)!!, 1e-18)
    }

    @Test
    fun testInvalidInput() {
        assertEquals(null, convertMetersToUnit("", LengthUnit.CENTIMETER))
        assertEquals(null, convertMetersToUnit("abc", LengthUnit.CENTIMETER))
        assertEquals(null, convertMetersToUnit("-", LengthUnit.CENTIMETER))
    }

    @Test
    fun testFormattingThreshold() {
        assertEquals("5E-4", formatResult(0.0005))

        val normalResult = formatResult(0.005)
        assert(normalResult == "0,005" || normalResult == "0.005")
    }
}