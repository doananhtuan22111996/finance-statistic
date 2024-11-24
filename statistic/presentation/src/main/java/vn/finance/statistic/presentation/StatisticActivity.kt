package vn.finance.statistic.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import vn.finance.navigation.NavigationManager
import vn.finance.theme.AppTheme
import javax.inject.Inject

@AndroidEntryPoint
class StatisticActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppTheme {
                StatisticNavHost(
                    navigationManager = navigationManager,
                    navController = navController
                )
            }
        }
    }
}