package com.example.material3checkboxesswitchesradiobuttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtons() {
    val radioButtons = remember{
        mutableStateListOf(
            ToggleableInfo(
                isChecked = true, text = "radio1"
            ),
            ToggleableInfo(
                isChecked = false, text = "radio2"
            ),
            ToggleableInfo(
                isChecked = false, text = "radio3"
            )
        )
    }

    radioButtons.forEachIndexed { _, toggleableInfo ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
        ) {
            RadioButton(
                selected = toggleableInfo.isChecked,
                onClick = {
                    radioButtons.replaceAll {
                        it.copy(
                            isChecked = it.text == toggleableInfo.text
                        )
                    }
                }
            )
            Text(text = toggleableInfo.text)
        }
    }
}