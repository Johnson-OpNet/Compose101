package com.jung.compose101.screen.week1

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jung.compose101.ui.theme.Compose101Theme

data class Event(val id: String, val home: String, val away: String)

private val events = listOf(
    Event(id = "1", home = "Lakers", away = "Cavaliers"),
    Event(id = "2", home = "Pistons", away = "Suns"),
    Event(id = "3", home = "76ers", away = "Pelicans"),
    Event(id = "4", home = "Hawks", away = "Nuggets"),
    Event(id = "5", home = "Nicks", away = "Timberwolves"),
    Event(id = "6", home = "Rockets", away = "Kings"),
    Event(id = "7", home = "Bucks", away = "Hornets"),
    Event(id = "8", home = "Mavericks", away = "Raptors"),
    Event(id = "9", home = "Celtics", away = "Warriors"),
    Event(id = "10", home = "Bulls", away = "Nets"),
    Event(id = "11", home = "Heat", away = "Spurs"),
    Event(id = "12", home = "Wizards", away = "Grizzlies"),
)

@Composable
fun LazyItems() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items = events, key = { it.id }) { e ->
            Text(
                text = "${e.home} vs ${e.away}",
                modifier = Modifier.padding(vertical = 16.dp),
                fontSize = 20.sp,
            )
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyItemsPreview() {
    Compose101Theme {
        LazyItems()
    }
}