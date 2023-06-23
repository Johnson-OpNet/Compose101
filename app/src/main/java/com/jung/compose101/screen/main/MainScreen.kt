package com.jung.compose101.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jung.compose101.R
import com.jung.compose101.navigation.WeekRoute
import com.jung.compose101.navigation.Destination
import com.jung.compose101.ui.theme.Compose101Theme

@Composable
fun MainScreen(
    navigate: (Destination) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            style = MaterialTheme.typography.titleMedium,
        )

        Button(onClick = { navigate(Destination(WeekRoute.Week1Screen.route)) }) {
            Text(text = stringResource(id = R.string.week_1))
        }

        Button(onClick = { navigate(Destination(WeekRoute.Week3Screen.route)) }) {
            Text(text = stringResource(id = R.string.week_3))
        }

        Button(onClick = { navigate(Destination(WeekRoute.Week4Screen.route)) }) {
            Text(text = stringResource(id = R.string.week_4))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Compose101Theme {
        MainScreen(navigate = {})
    }
}