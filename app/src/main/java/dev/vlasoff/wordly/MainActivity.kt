package dev.vlasoff.wordly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.vlasoff.wordly.presentation.Board
import dev.vlasoff.wordly.presentation.RussianKeyboard
import dev.vlasoff.wordly.util.getScreenHeightInDp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                Board(answer = "AAAAA", getScreenSpacerHeight(percent = 0.1))
                RussianKeyboard(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = getScreenSpacerHeight(percent = 0.07)
                        )
                        .align(alignment = Alignment.BottomCenter)
                ) { println("A") }
            }
        }
    }

    @Composable
    private fun getScreenSpacerHeight(percent: Double): Dp {
        return getScreenHeightInDp().times(percent).dp
    }
}