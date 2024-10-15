package com.prabhanshu.bottomnavigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
object ChatsScreenRoute

@Serializable
object ProfileScreenRoute

@Serializable
object BottomNavigationRoute

@Serializable
object BottomNavigationItemRoute


sealed class Route(val route: String) {
    object HomeScreen : Route(route = "HomeScreen")
    object ChatsScreen : Route(route = "ChatsScreen")
    object ProfileScreen : Route(route = "ProfileScreen")

}