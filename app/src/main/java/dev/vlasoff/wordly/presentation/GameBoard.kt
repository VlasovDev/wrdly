package dev.vlasoff.wordly.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vlasoff.wordly.util.getScreenWidthInDp

@Composable
fun Board(
    answer: String
) {
    val boxSize = calculateOptimalBoxesSizeByWordsLength(wordLen = answer.length)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val len = answer.length
        for (i in 0..len) {
            Row  {
                for (j in answer.indices) {
                    LetterBox(letter = "A", boxSize = boxSize)
                }
            }
        }
    }
}

@Composable
fun LetterBox(
    letter: String = " ",
    boxSize: Int
) {
    val letterState by remember { mutableStateOf(letter) }
    Box(
        modifier = Modifier
            .padding(horizontal = 1.dp, vertical = 4.dp)
            .size(boxSize.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp),
            )
    ) {
        Text(
            text = letterState,
            fontSize = (boxSize / 1.5).sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun calculateOptimalBoxesSizeByWordsLength(wordLen: Int): Int {
    val screenWidth = getScreenWidthInDp()
    return screenWidth / (wordLen + 2)
}


@Composable
@Preview
fun GameBoardPreview() {
    Board("ABCDEFGHIJKL")
}