package dev.vlasoff.wordly.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vlasoff.wordly.ui.theme.LetterBoxBackground

@Composable
fun RussianKeyboard(
    modifier: Modifier,
    onKeyPress: (String) -> Unit
) {
    val rows = listOf(
        "ЙЦУКЕНГШЩЗХЪ",
        "ФЫВАПРОЛДЖЭ",
        "⬅ЯЧСМИТЬБЮ⏎"
    )

    Column(
        modifier = modifier,
    ) {
        for (row in rows) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                for (letter in row) {
                    Key(
                        letter = letter.toString(),
                        modifier = Modifier
                            .padding(horizontal = 1.4.dp, vertical = 4.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .height(48.dp)
                            .background(color = LetterBoxBackground)
                            .clickable { onKeyPress(letter.toString()) }
                            .weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun Key(
    letter: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        Text(
            text = letter,
            fontSize = (48 / 1.5).sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
