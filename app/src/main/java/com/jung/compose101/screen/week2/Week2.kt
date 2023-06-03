package com.jung.compose101.screen.week2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jung.compose101.R
import com.jung.compose101.ui.theme.PurpleGrey80

@Composable
fun Week2() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image1()
        Image2()
        Image3()

        Text1()
        Text2()
    }
}

@Composable
fun Image1() {
    Image(
        painter = painterResource(id = R.drawable.ic_space),
        contentDescription = null,
    )
}

@Composable
fun Image2() {
    /* Image 2 : content size under or over the container */
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_space),
            contentDescription = null,
            modifier = Modifier.size(500.dp)
        )
    }
}

@Composable
fun Image3() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_space),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .padding(10.dp)
                .size(100.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_space),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp)
                .clip(CircleShape),
        )
    }
}

@Composable
fun Text1() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Small Background",
            modifier = Modifier
                .padding(16.dp)
                .background(PurpleGrey80),
        )

        Text(
            text = "Large Background",
            modifier = Modifier
                .background(PurpleGrey80)
                .padding(16.dp),
        )
    }
}

@Composable
fun Text2() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Small Clickable",
            modifier = Modifier
                .background(PurpleGrey80)
                .padding(16.dp)
                .clickable { println("Small Clickable") },
        )

        Text(
            text = "Large Clickable",
            modifier = Modifier
                .clickable { println("Large Clickable") }
                .background(PurpleGrey80)
                .padding(16.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Week2Preview() {
    Week2()
}
