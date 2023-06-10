package com.jung.compose101.screen.week3.contract

import com.jung.compose101.screen.week1.Event

data class Week3State(
    val events: List<Event> = mockEvents,
)

private val mockEvents = listOf(
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