package com.jung.compose101.screen.week4.stabledemo

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FriendsViewModel : ViewModel() {
    private val _uiStateFlow: MutableStateFlow<FriendsState> = MutableStateFlow(FriendsState())
    val uiStateFlow: StateFlow<FriendsState> = _uiStateFlow.asStateFlow()

    init {
        _uiStateFlow.update { createMockState() }
    }

    fun handleEvent(e: FriendsEvent) {
        when (e) {
            is FriendsEvent.Like -> {
                _uiStateFlow.update { state ->
                    val index = state.friends.friendList
                        .indexOfFirst { it.id == e.id }
                        .takeIf { it >= 0 }
                        ?: return@update state
                    val oldFriend = state.friends.friendList[index]

                    // MutableList
                    val newList = state.friends.friendList.toMutableList()
                        .apply { set(index, oldFriend.copy(like = !oldFriend.like)) }

                    // ImmutableList
//                    val newList = state.friends.friendList
//                        .set(index, oldFriend.copy(like = !oldFriend.like))

                    val newFriends = state.friends.copy(friendList = newList)
                    state.copy(friends = newFriends)
                }
            }

            is FriendsEvent.Remove -> {
                _uiStateFlow.update { state ->
                    val index = state.friends.friendList
                        .indexOfFirst { it.id == e.id }
                        .takeIf { it >= 0 }
                        ?: return@update state

                    // MutableList
                    val newList = state.friends.friendList.toMutableList()
                        .apply { removeAt(index) }

                    // ImmutableList
//                    val newList = state.friends.friendList
//                        .removeAt(index)

                    val newFriends = state.friends.copy(friendList = newList)
                    state.copy(friends = newFriends)
                }
            }
        }
    }

    private fun createMockState() = FriendsState(
        me = User(name = "Johnson"),
        friends = Friends(
            friendList = listOf(
                User(id = 1, name = "John"),
                User(id = 2, name = "Hill"),
                User(id = 3, name = "Ken"),
                User(id = 4, name = "Edison"),
                User(id = 5, name = "Dino"),
                User(id = 6, name = "Benson"),
                User(id = 7, name = "Shawn"),
            ),

//            friendList = persistentListOf(
//                User(id = 1, name = "John"),
//                User(id = 2, name = "Hill"),
//                User(id = 3, name = "Ken"),
//                User(id = 4, name = "Edison"),
//                User(id = 5, name = "Dino"),
//                User(id = 6, name = "Benson"),
//                User(id = 7, name = "Shawn"),
//            ),
        )
    )
}