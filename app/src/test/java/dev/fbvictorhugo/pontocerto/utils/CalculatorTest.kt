package dev.fbvictorhugo.pontocerto.utils

import dev.fbvictorhugo.pontocerto.domain.Checkpoint
import org.junit.Assert
import org.junit.Test
import java.util.Date

class CalculatorTest {

    @Test
    fun `Calc normal time remaining`() {
        val checkpoint = Checkpoint(
            date = Formatters.formatDate(Date()),
            workIn = "09:00",
            lunchIn = "12:00",
            lunchOut = "13:00"
        )

        val updatedCheckpoint = Calculator.calcTimeRemaining(checkpoint)
        Assert.assertEquals(updatedCheckpoint.workOutPrev, "18:00")
    }

    @Test
    fun `Calc extended lunch time`() {
        val checkpoint = Checkpoint(
            date = Formatters.formatDate(Date()),
            workIn = "09:00",
            lunchIn = "12:00",
            lunchOut = "13:30"
        )

        val updatedCheckpoint = Calculator.calcTimeRemaining(checkpoint)
        Assert.assertEquals(updatedCheckpoint.workOutPrev, "18:30")
    }

    @Test
    fun `Calc extended extra lunch time`() {
        val checkpoint = Checkpoint(
            date = Formatters.formatDate(Date()),
            workIn = "09:00",
            lunchIn = "12:00",
            lunchOut = "17:11"
        )

        val updatedCheckpoint = Calculator.calcTimeRemaining(checkpoint)
        Assert.assertEquals(updatedCheckpoint.workOutPrev, "22:11")
    }

}