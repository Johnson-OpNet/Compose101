package com.jung.compose101.screen.week4.stabledemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jung.compose101.R
import com.jung.compose101.screen.common.TopBar

@Composable
fun FriendScreen(
    uiState: FriendsState,
    uiEvent: (FriendsEvent) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = R.string.friends_list,
            onArrowClick = {},
        )

        Text(
            text = "Me: ${uiState.me.name}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 20.sp,
        )

        Divider()

        FriendList(
            friends = uiState.friends,
            uiEvent = uiEvent,
        )
    }
}

@Composable
private fun FriendList(
    friends: Friends,
    uiEvent: (FriendsEvent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(
            items = friends.friendList,
            key = { user -> user.id }
        ) {
            Friend(
                user = it,
                likeClick = { uiEvent(FriendsEvent.Like(it.id)) },
                removeClick = { uiEvent(FriendsEvent.Remove(it.id)) },
            )
        }
    }
}

@Composable
private fun Friend(
    user: User,
    likeClick: () -> Unit,
    removeClick: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "ID: ${user.id}",
                modifier = Modifier.weight(1f),
                fontSize = 18.sp,
            )

            Text(
                text = "Name: ${user.name}",
                modifier = Modifier.weight(2f),
                fontSize = 16.sp,
            )

            IconButton(onClick = likeClick) {
                Image(
                    painter = painterResource(
                        id = if (user.like) R.drawable.ic_star else R.drawable.ic_star_border,
                    ),
//                    imageVector = ImageVector.vectorResource(
//                        id = if (user.like) R.drawable.ic_star else R.drawable.ic_star_border
//                    ),
                    contentDescription = null,
                )
            }

            IconButton(onClick = removeClick) {
                Image(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = null,
                )
            }
        }

        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun FriendListPreview() {
    FriendScreen(
        uiState = FriendsState(
            me = User(name = "Johnson"),
            friends = Friends(friendList = listOf(User(id = 1, name = "Johnson")))
//            friends = Friends(friendList = persistentListOf(User(id = 1, name = "Johnson")))
        ),
        uiEvent = {},
    )
}