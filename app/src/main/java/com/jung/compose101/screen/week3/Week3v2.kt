package com.jung.compose101.screen.week3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import com.jung.compose101.R
import com.jung.compose101.screen.week1.Event
import com.jung.compose101.screen.week3.contract.Week3Event
import com.jung.compose101.screen.week3.contract.Week3State

@Composable
fun Week3v2(
    uiState: Week3State,
    uiEvent: (Week3Event) -> Unit,
) {

    var num by remember { mutableStateOf(1) }

    var count1 by remember { mutableStateOf(0) }
    var count2 by remember { mutableStateOf(0) }
    var count3 by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SwitchBtnRow(onTabSelect = { num = it })

        Divider()

        when (num) {
            1 -> Screen(
                screenNum = 1,
                count = count1,
                increaseCount = { count1++ },
                decreaseCount = { count1-- },
                eventList = uiState.events,
                delete = { uiEvent(Week3Event.DeleteItem(it)) },
            )

            2 -> Screen(
                screenNum = 2,
                count = count2,
                increaseCount = { count2++ },
                decreaseCount = { count2-- },
                eventList = uiState.events,
                delete = { uiEvent(Week3Event.DeleteItem(it)) },
            )

            3 -> Screen(
                screenNum = 3,
                count = count3,
                increaseCount = { count3++ },
                decreaseCount = { count3-- },
                eventList = uiState.events,
                delete = { uiEvent(Week3Event.DeleteItem(it)) },
            )
        }
    }
}

@Composable
private fun Screen(
    screenNum: Int,
    count: Int,
    increaseCount: () -> Unit,
    decreaseCount: () -> Unit,
    eventList: List<Event>,
    delete: (String) -> Unit,
) {
    Text(
        text = "$screenNum",
        modifier = Modifier.padding(all = 8.dp),
        fontSize = 20.sp,
    )

    Counter(
        countNum = count,
        increaseCount = increaseCount,
        decreaseCount = decreaseCount,
    )

    EventList(eventList = eventList, delete = delete)
}


@Composable
private fun EventList(
    eventList: List<Event>,
    delete: (String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = eventList,
            key = { it.id },
        ) {
            Event(
                event = it,
                deleteClick = { delete(it.id) },
            )
            Divider()
        }
    }
}

@Composable
private fun Event(
    event: Event,
    deleteClick: () -> Unit,
) {

    var like by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 30.dp),
    ) {
        Text(
            text = "${event.home} vs ${event.away}",
            modifier = Modifier.weight(4f),
        )

        Image(
            painter = painterResource(
                id = if (like) R.drawable.ic_star else R.drawable.ic_star_border,
            ),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    like = !like
                },
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .clickable { deleteClick() },
        )
    }

    DisposableEffect(Unit) {

        println("DisposableEffect")

        onDispose {
            println("onDispose: ${event.home} vs ${event.away}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Week3v2Preview() {
    Week3v2(
        uiState = Week3State(),
        uiEvent = {},
    )
}