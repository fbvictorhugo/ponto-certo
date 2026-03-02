package dev.fbvictorhugo.pontocerto.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventSeat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import dev.fbvictorhugo.pontocerto.domain.TimeClockEvent
import dev.fbvictorhugo.pontocerto.ui.theme.Dimens
import dev.fbvictorhugo.pontocerto.ui.theme.PontoCertoTheme
import dev.fbvictorhugo.pontocerto.ui.theme.Typography

/**
 * A composable row that displays a clock-in/out event with its corresponding icon and fill time.
 *
 * @param event The type of time clock event (e.g., WORK_IN, LUNCH_IN) which determines the icon shown.
 * @param formattedTime The string representation of the time to be displayed "HH:mm" format. Defaults to the "--:--" fill time.
 * @param modifier The [Modifier] to be applied to the row layout.
 */
@Composable
fun ClockInField(
    event: TimeClockEvent,
    formattedTime: String?,
    formattedTimePrev: String,
    modifier: Modifier = Modifier
) {

    val isPlaceholder = formattedTime.isNullOrEmpty()

    val color = if (isPlaceholder) {
        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    } else {
        MaterialTheme.colorScheme.primary
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.PaddingSmall),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Icon(
            imageVector = getClockInImageVector(event),
            contentDescription = null,
            Modifier.size(Dimens.IconSizeLarge),
            tint = color
        )
        Text(
            if (isPlaceholder) formattedTimePrev else formattedTime,
            modifier = Modifier.padding(start = Dimens.PaddingMedium),
            style = Typography.displaySmall,
            color = color
        )
    }
}

/**
 * Returns the appropriate [ImageVector] icon based on the provided [TimeClockEvent].
 *
 * @param event The clock-in/out event type used to determine the icon.
 * @return An [ImageVector] representing the event.
 */
private fun getClockInImageVector(event: TimeClockEvent): ImageVector {
    return when (event) {
        TimeClockEvent.WORK_IN -> Icons.Filled.Work
        TimeClockEvent.LUNCH_IN -> Icons.Filled.LocalDining
        TimeClockEvent.LUNCH_OUT -> Icons.Filled.EventSeat
        TimeClockEvent.WORK_OUT -> Icons.Filled.Home
    }
}

@Preview(showBackground = true)
@Composable
private fun ClockInFieldView() {
    PontoCertoTheme {
        ClockInField(
            event = TimeClockEvent.WORK_IN,
            formattedTime = "08:00",
            formattedTimePrev = "08:00"
        )
    }
}
