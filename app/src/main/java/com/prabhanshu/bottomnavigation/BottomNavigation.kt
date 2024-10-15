package com.prabhanshu.bottomnavigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController



data class bottomNavigationItem(
    val name: String,
    val icon: ImageVector
)
@Composable
fun BottomNavigation (){
    val bottomNavigationItems = listOf(

        bottomNavigationItem(
            name = "Home",
            icon = Icons.Default.Home
        ),
        bottomNavigationItem(
            name = "Chats",
            icon = Icons.Default.MailOutline
        ),
        bottomNavigationItem(
            name = "Profile",
            icon = Icons.Default.Settings
        )

    )
    var navController =rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState().value
    var selectedItem  by rememberSaveable {
        mutableStateOf(0)
    }
    selectedItem = remember (key1 = backStackEntry) {
        when (backStackEntry?.destination?.route) {
          Route.HomeScreen.route -> 0
            Route.ChatsScreen.route -> 1
            Route.ProfileScreen.route -> 2
            else -> 0
        }
    }

    val isbottomBarVisible = remember(key1 = backStackEntry) {
        backStackEntry?.destination?.route == Route.HomeScreen.route ||
                backStackEntry?.destination?.route == Route.ChatsScreen.route ||
                backStackEntry?.destination?.route == Route.ProfileScreen.route
    }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isbottomBarVisible){
                MainBottomNavigation(
                    items = bottomNavigationItems,
                    selectedItem = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTab (
                                navController =navController,
                                route = Route.HomeScreen.route
                            )
                            1 -> navigateToTab (
                                navController =navController,
                                route = Route.ChatsScreen.route
                            )
                            2 -> navigateToTab (
                                navController =navController,
                                route = Route.ProfileScreen.route
                            )

                        }
                    }
                )
            }
        }

    ){
        val bottomPadding = it.calculateBottomPadding()
        NavGraph(navController,bottomPadding)

    }

}

 private fun navigateToTab(navController : NavController ,route: String){
      navController.navigate(route){
          navController.graph.startDestinationRoute?.let { homeScreen ->
              popUpTo(homeScreen){
                  saveState = true
              }
          }
          restoreState = true
          launchSingleTop = true
      }
 }
