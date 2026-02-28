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
import dev.fbvictorhugo.pontocerto.utils.Formatters
import java.util.Date

@Composable
fun ClockInField(
    event: TimeClockEvent,
    date: Date,
    modifier: Modifier = Modifier
) {
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
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            Formatters.formatHour(date), modifier = Modifier.padding(start = Dimens.PaddingMedium),
            style = Typography.displaySmall
        )
    }

}

private fun getClockInImageVector(event: TimeClockEvent): ImageVector {
    return when (event) {
        TimeClockEvent.CLOCK_IN -> Icons.Filled.Work
        TimeClockEvent.LUNCH_IN -> Icons.Filled.LocalDining
        TimeClockEvent.LUNCH_OUT -> Icons.Filled.EventSeat
        TimeClockEvent.CLOCK_OUT -> Icons.Filled.Home
    }
}

@Preview(showBackground = true)
@Composable
private fun ClockInFieldView() {
    PontoCertoTheme {
        ClockInField(
            event = TimeClockEvent.CLOCK_IN,
            date = Date(),
        )
    }
}

