package dev.fbvictorhugo.pontocerto.utils

import dev.fbvictorhugo.pontocerto.domain.Checkpoint
import java.util.Calendar
import java.util.Date

class Calculator {

    companion object {

        /**
         * Adds an hour to a given date.
         */
        fun addHour(date: Date, hour: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.HOUR, hour)
            return calendar.time
        }

        /**
         * Calculates the expected clock-out time based on an 8-hour workday.
         *
         * This function computes the remaining work time needed after the lunch break
         * by subtracting the morning session duration from the 8-hour total, then
         * adding that duration to the lunch-out time.
         *
         * @param checkpoint The [Checkpoint] containing the work-in, lunch-in, and lunch-out timestamps.
         * @return A copy of the [Checkpoint] with the `workOutPrev` field updated if all required
         * timestamps are present; otherwise, returns the original [checkpoint].
         */
        fun calcTimeRemaining(checkpoint: Checkpoint): Checkpoint {
            val workIn = Formatters.toDate(checkpoint.workIn)
            val lunchIn = Formatters.toDate(checkpoint.lunchIn)
            val lunchOut = Formatters.toDate(checkpoint.lunchOut)

            if (workIn != null && lunchIn != null && lunchOut != null) {
                val morningWorkMs = lunchIn.time - workIn.time
                val lunchDurationMs = lunchOut.time - lunchIn.time
                val totalWorkNeededMs = 8 * 60 * 60 * 1000L
                val afternoonWorkNeededMs = totalWorkNeededMs - morningWorkMs
                val workOutExpected = Date(lunchOut.time + afternoonWorkNeededMs)

                return checkpoint.copy(
                    workOutPrev = Formatters.formatHour(workOutExpected)
                )
            }
            return checkpoint
        }


    }
}