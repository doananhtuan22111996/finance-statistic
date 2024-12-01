package vn.finance.statistic

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vn.finance.statistic.presentation.PATH
import vn.finance.statistic.presentation.statistic.StatisticView

@Composable
fun StatisticNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = PATH) {
        composable(PATH) {
            StatisticView()
        }
    }
}