package com.jung.compose101.screen.week1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jung.compose101.R
import com.jung.compose101.screen.common.TopBar
import com.jung.compose101.ui.theme.Compose101Theme

@Composable
fun Week1(navBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(title = R.string.week_1, onArrowClick = navBack)

        Counter()

        TabsWithPager()
    }
}

@Preview(showBackground = true)
@Composable
fun Week1Preview() {
    Compose101Theme {
        Week1(navBack = {})
    }
}