package vn.finance.statistic.api

import androidx.compose.runtime.Composable

interface StatisticApi {

    val path: String

    @Composable
    fun StatisticPage()

    @Composable
    fun StatisticPageWithoutScrollState()
}
