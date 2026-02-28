package dev.fbvictorhugo.pontocerto.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.fbvictorhugo.pontocerto.ui.theme.Dimens
import dev.fbvictorhugo.pontocerto.ui.theme.PontoCertoTheme
import dev.fbvictorhugo.pontocerto.ui.theme.Typography
import dev.fbvictorhugo.pontocerto.utils.Formatters
import java.util.Date

@Composable
fun HeaderToday(
    date: Date,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(Dimens.SpacerHeight))

        Text(
            text = Formatters.formatDate(date),
            modifier = Modifier.fillMaxWidth(),
            style = Typography.displayMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = Formatters.formatDay(date),
            modifier = Modifier.fillMaxWidth(),
            style = Typography.displaySmall,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderTodayPreview() {
    PontoCertoTheme {
        HeaderToday(Date())
    }
}

