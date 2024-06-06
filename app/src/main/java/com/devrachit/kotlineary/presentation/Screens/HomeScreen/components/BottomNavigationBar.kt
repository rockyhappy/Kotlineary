package com.devrachit.kotlineary.presentation.Screens.HomeScreen.components


import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.devrachit.kotlineary.R
import com.devrachit.kotlineary.presentation.navigation.AppScreens
import com.devrachit.kotlineary.ui.theme.DarkGreyColor
import com.devrachit.kotlineary.ui.theme.primaryColor

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = ImageVector.vectorResource(id = R.drawable.home_selected),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.home_unselected),
            route = AppScreens.HomeScreen.route
        ),
        BottomNavigationItem(
            title = "Favorite",
            selectedIcon = ImageVector.vectorResource(id = R.drawable.favorite_selected),
            unselectedIcon = ImageVector.vectorResource(id = R.drawable.favorite_unselected),
            route = AppScreens.FavoriteScreen.route
        )
    )

    NavigationBar(
        containerColor = Color.White,
    ) {
        items.forEach { bottomNavigationItem ->
            val selected = currentRoute == bottomNavigationItem.route
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (selected) {
                            bottomNavigationItem.selectedIcon
                        } else {
                            bottomNavigationItem.unselectedIcon
                        },
                        contentDescription = bottomNavigationItem.title
                    )
                },
                label = {
                    Text(
                        text = bottomNavigationItem.title,
                        color = if (selected) {
                            primaryColor
                        } else {
                            DarkGreyColor
                        }
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(bottomNavigationItem.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = androidx.compose.material3.NavigationBarItemDefaults
                    .colors(
                        selectedIconColor = primaryColor,
                        indicatorColor = Color.White,
                    )
            )
        }
    }
}
