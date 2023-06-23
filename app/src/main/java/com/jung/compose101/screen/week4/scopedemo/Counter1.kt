package com.jung.compose101.screen.week4.scopedemo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter1() {

    var count by remember { mutableStateOf(0) }

    Text(
        text = count.toString(),
        modifier = Modifier
            .clickable { count++ }
            .fillMaxWidth()
            .height(60.dp)
            .wrapContentSize(),
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
    )
}

//    Button(onClick = { count++ }) {
//        Text(
//            text = count.toString(),
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(60.dp)
//                .wrapContentSize(),
//            fontSize = 24.sp,
//            textAlign = TextAlign.Center,
//        )
//    }

@Composable
private fun Count(count: Int, add: (Int) -> Unit) {
    Text(
        text = count.toString(),
        modifier = Modifier
            .clickable { add(count + 1) }
            .fillMaxWidth()
            .height(60.dp)
            .wrapContentSize(),
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
    )
}
//     Count(count = count, add = { count++ })


@Composable
private fun Count(content: @Composable () -> Unit) {
    content()
}
//    Count {
//        Text(
//            text = count.toString(),
//            modifier = Modifier
//                .clickable { count++ }
//                .fillMaxWidth()
//                .height(60.dp)
//                .wrapContentSize(),
//            fontSize = 24.sp,
//            textAlign = TextAlign.Center,
//        )
//    }

@Preview(showBackground = true)
@Composable
fun Week4Counter1Preview() {
    Counter1()
}