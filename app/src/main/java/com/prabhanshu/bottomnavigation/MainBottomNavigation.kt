package com.prabhanshu.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainBottomNavigation(
    items: List<bottomNavigationItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit
){
    NavigationBar (
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Transparent,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { onItemClick(index) },
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = "",
                            modifier = Modifier.size(45.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = item.name, style = MaterialTheme.typography.labelSmall)


                    }

                },
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                    selectedIndicatorColor = Color.Cyan,
                    disabledIconColor = Color.Unspecified,
                    disabledTextColor = Color.Gray

                )

            )
        }
    }
}