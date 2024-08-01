package dev.vlasoff.wordly.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun getScreenWidthInDp(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp
}
