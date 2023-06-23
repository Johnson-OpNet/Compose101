package com.jung.compose101.screen.week4.stabledemo

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class User(
    var id: Int = 0,
    val name: String = "",
    val like: Boolean = false,
)

// @Stable
data class Friends(
    val friendList: List<User> = mutableListOf(),
//    val friendList: PersistentList<User> = persistentListOf(),
)

data class FriendsState(
    val me: User = User(),
    val friends: Friends = Friends(),
)

sealed interface FriendsEvent {
    data class Like(val id: Int) : FriendsEvent
    data class Remove(val id: Int) : FriendsEvent
}
