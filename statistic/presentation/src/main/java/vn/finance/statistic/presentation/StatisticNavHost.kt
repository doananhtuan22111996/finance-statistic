package vn.finance.statistic.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vn.finance.navigation.NavigationManager
import vn.finance.statistic.presentation.statistic.StatisticView

const val STATISTIC = "statistic"

@Composable
fun StatisticNavHost(navigationManager: NavigationManager, navController: NavHostController) {
    NavHost(navController = navController, startDestination = STATISTIC) {
        composable(STATISTIC) {
            StatisticView(modifier = Modifier)
        }
    }
}