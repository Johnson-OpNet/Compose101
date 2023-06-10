package com.jung.compose101.screen.week3.contract

sealed interface Week3Event {
    data class DeleteItem(val id: String) : Week3Event
}