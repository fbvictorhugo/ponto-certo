package dev.fbvictorhugo.pontocerto.ui.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.fbvictorhugo.pontocerto.domain.TimeClockEvent
import dev.fbvictorhugo.pontocerto.ui.components.ClockInField
import dev.fbvictorhugo.pontocerto.ui.components.HeaderToday
import dev.fbvictorhugo.pontocerto.ui.components.Line
import dev.fbvictorhugo.pontocerto.ui.theme.Dimens
import dev.fbvictorhugo.pontocerto.ui.theme.PontoCertoTheme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    PontoCertoTheme {
        Surface {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        //TODO
                    }) {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = null)
                    }
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(horizontal = Dimens.PaddingLarge)
                ) {
                    HeaderToday(Date())
                    Spacer(Modifier.padding(vertical = Dimens.PaddingMedium))
                    Line()
                    Spacer(Modifier.padding(vertical = Dimens.PaddingMedium))

                    ClockInField(TimeClockEvent.WORK_IN)
                    ClockInField(TimeClockEvent.LUNCH_IN)
                    ClockInField(TimeClockEvent.LUNCH_OUT)
                    ClockInField(TimeClockEvent.WORK_OUT)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    PontoCertoTheme {
        App()
    }
}