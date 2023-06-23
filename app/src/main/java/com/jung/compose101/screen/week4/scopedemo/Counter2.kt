package com.jung.compose101.screen.week4.scopedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jung.compose101.ui.theme.Pink80

@Composable
fun Counter2() {

    var count by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Pink80)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CalcBtn(calcSign = "+", calcAction = { count++ })

        Text(text = count.toString(), fontSize = 24.sp)

        CalcBtn(calcSign = "-", calcAction = { count-- })
    }
}

@Composable
private fun Count(content: @Composable () -> Unit) {
    content()
}
//Count {
//    Text(text = count.toString(), fontSize = 24.sp)
//}

@Composable
private fun CalcBtn(calcSign: String, calcAction: () -> Unit) {
    Button(onClick = calcAction) {
        Text(
            text = calcSign,
            modifier = Modifier.padding(horizontal = 8.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Week4Counter2Preview() {
    Counter2()
}

