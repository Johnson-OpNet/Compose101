package com.jung.compose101.screen.common

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jung.compose101.R
import com.jung.compose101.ui.theme.Compose101Theme
import com.jung.compose101.ui.theme.Purple80

@Composable
fun TopBar(@StringRes title: Int, onArrowClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Purple80),
    ) {
        IconButton(onClick = onArrowClick) {
            Icon(
                painter = painterResource(id = R.drawable.round_arrow_back),
                contentDescription = null,
            )
        }

        Text(
            text = stringResource(title),
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    Compose101Theme {
        TopBar(title = R.string.week_1, onArrowClick = {})
    }
}