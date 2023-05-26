package com.jung.compose101.screen.week1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jung.compose101.ui.theme.Compose101Theme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsWithPager() {

    val pageCount = 2
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Tab(
                selected = pagerState.currentPage == 0,
                onClick = { coroutineScope.launch { pagerState.scrollToPage(0) } },
            ) {
                Text(text = "Page 1", modifier = Modifier.padding(vertical = 12.dp))
            }
            Tab(
                selected = pagerState.currentPage == 1,
                onClick = { coroutineScope.launch { pagerState.scrollToPage(1) } },
            ) {
                Text(text = "Page 2", modifier = Modifier.padding(vertical = 12.dp))
            }
        }

        HorizontalPager(pageCount = pageCount, state = pagerState) { page ->
            when (page) {
                0 -> Login()
                else -> LazyItems()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabsWithPagerPreview() {
    Compose101Theme {
        TabsWithPager()
    }
}