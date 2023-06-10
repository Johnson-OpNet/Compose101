package com.jung.compose101.screen.week1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.jung.compose101.ui.theme.Compose101Theme
import com.jung.compose101.ui.theme.Pink80
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/** Stateful */
@Composable
fun Counter(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {

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

//    LaunchedEffect(Unit) {
//        launch {
//            repeat(1000) {
//                println("$it")
//                delay(1000)
//            }
//        }
//        println("LaunchedEffect scope: $this")
//    }

//    SideEffect {
//        println("SideEffect")
//    }

//    DisposableEffect(count) {
//
//        println("DisposableEffect")
//
//        val observer = LifecycleEventObserver { _, event ->
//            if (event == Lifecycle.Event.ON_RESUME) {
//                println("ON_RESUME")
//            } else if (event == Lifecycle.Event.ON_PAUSE) {
//                println("ON_PAUSE")
//            }
//        }
//        lifecycleOwner.lifecycle.addObserver(observer)
//
//        onDispose {
//            println("onDispose")
//            lifecycleOwner.lifecycle.removeObserver(observer)
//        }
//    }
}

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
fun CounterPreview() {
    Compose101Theme {
        Counter()
    }
}