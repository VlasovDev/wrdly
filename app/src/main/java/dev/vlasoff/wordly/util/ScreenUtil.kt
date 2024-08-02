package dev.vlasoff.wordly.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun getScreenParamsInDp(): ScreenParams {
    val configuration = LocalConfiguration.current
    return ScreenParams(
        height = configuration.screenHeightDp,
        width = configuration.screenWidthDp
    )
}

@Composable
fun getScreenWidthInDp() = getScreenParamsInDp().width


@Composable
fun getScreenHeightInDp() = getScreenParamsInDp().height

data class ScreenParams(
    val height: Int,
    val width: Int
)
