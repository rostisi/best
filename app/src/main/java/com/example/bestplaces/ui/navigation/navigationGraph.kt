package com.example.tourisplace1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tourisplace1.data.Destination
import com.example.tourisplace1.ui.screen.DestinationDetailScreen
import com.example.tourisplace1.ui.screen.DestinationListScreen

@Composable
fun Navigation(destinations: List<Destination>) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "destinationList") {
        composable("destinationList") {
            DestinationListScreen(destinations) { destination ->
                navController.navigate("destinationDetail/${destination.id}")
            }
        }
        composable(
            "destinationDetail/{destinationId}",
            arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val destinationId = backStackEntry.arguments?.getInt("destinationId")
            val destination = destinations.find { it.id == destinationId }
            destination?.let { DestinationDetailScreen(it) }
        }
    }
}
