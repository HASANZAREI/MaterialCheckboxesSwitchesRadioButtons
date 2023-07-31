package com.example.material3checkboxesswitchesradiobuttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

data class ToggleableInfo(
    val isChecked: Boolean,
    val text: String
)

@Composable
fun Checkboxes() {
    val checkboxes = remember{
        mutableStateListOf(
            ToggleableInfo(
                isChecked = false, text = "Check1"
            ),
            ToggleableInfo(
                isChecked = false, text = "Check2"
            ),
            ToggleableInfo(
                isChecked = false, text = "Check3"
            )
        )
    }

    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }

    val toggleTriState = {
        triState = when(triState){
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        checkboxes.indices.forEach {
            checkboxes[it] = checkboxes[it].copy(
                isChecked = triState == ToggleableState.On
            )
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TriStateCheckbox(
            state = triState,
            onClick = toggleTriState
        )
        Text(text = "Try it")
    }

    checkboxes.forEachIndexed { index, toggleableInfo ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
        ) {
            Checkbox(
                checked = toggleableInfo.isChecked,
                onCheckedChange = {
                    checkboxes[index] = toggleableInfo.copy(
                        isChecked = it
                    )
                }
            )
            Text(text = toggleableInfo.text)
        }
    }
}