package com.jung.compose101.screen.week3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Week3v1() {

    var num by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SwitchBtnRow(onTabSelect = { num = it })

        Divider()

        when (num) {
            1 -> Screen(screenNum = 1)

            2 -> Screen(screenNum = 2)

            3 -> Screen(screenNum = 3)
        }
    }
}

@Composable
private fun Screen(screenNum: Int) {
    var count by remember { mutableStateOf(0) }
    // var count by rememberSaveable { mutableStateOf(0) }

    Text(
        text = "$screenNum",
        modifier = Modifier.padding(all = 8.dp),
        fontSize = 20.sp,
    )

    Counter(
        countNum = count,
        increaseCount = { count++ },
        decreaseCount = { count-- },
    )
}


@Preview(showBackground = true)
@Composable
fun Week3v1Preview() {
    Week3v1()
}