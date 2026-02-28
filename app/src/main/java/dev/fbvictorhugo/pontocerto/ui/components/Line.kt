package dev.fbvictorhugo.pontocerto.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.fbvictorhugo.pontocerto.ui.theme.PontoCertoTheme

@Composable
fun Line(
    modifier: Modifier = Modifier,
    thickness: Dp = 6.dp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    HorizontalDivider(
        modifier = modifier.fillMaxWidth(),
        thickness = thickness,
        color = color
    )
}

@Preview(showBackground = true)
@Composable
private fun LinePreview() {
    PontoCertoTheme {
        Line(modifier = Modifier.padding(vertical = 8.dp))
    }
}