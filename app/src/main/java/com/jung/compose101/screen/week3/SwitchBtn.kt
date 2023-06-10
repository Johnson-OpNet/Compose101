package com.jung.compose101.screen.week3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SwitchBtnRow(onTabSelect: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        SwitchBtn(num = 1, onClick = { onTabSelect(1) })
        SwitchBtn(num = 2, onClick = { onTabSelect(2) })
        SwitchBtn(num = 3, onClick = { onTabSelect(3) })
    }
}

@Composable
private fun SwitchBtn(num: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(
            text = "$num",
            modifier = Modifier.padding(horizontal = 8.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchBtnRowPreview() {
    SwitchBtnRow(onTabSelect = {})
}