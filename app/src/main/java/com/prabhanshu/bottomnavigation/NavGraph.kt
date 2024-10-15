package com.prabhanshu.bottomnavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prabhanshu.bottomnavigation.Screens.ChatScreen
import com.prabhanshu.bottomnavigation.Screens.HomeScreen
import com.prabhanshu.bottomnavigation.Screens.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController,bottomPadding: Dp){
    NavHost(
        navController = navController,
        startDestination = Route.HomeScreen.route,
        modifier = Modifier.padding(bottom = bottomPadding)
    ){
        composable(route = Route.HomeScreen.route){
            HomeScreen()
        }
        composable(route = Route.ChatsScreen.route){
            ChatScreen()
        }
        composable(route = Route.ProfileScreen.route){
            ProfileScreen()
        }
    }

}