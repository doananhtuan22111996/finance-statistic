package vn.finance.statistic.presentation.api

import androidx.compose.runtime.Composable
import vn.finance.statistic.api.StatisticApi
import vn.finance.statistic.presentation.PATH
import vn.finance.statistic.presentation.statistic.StatisticView
import vn.finance.statistic.presentation.statistic.StatisticViewWithoutScrollState

class StatisticApiImpl : StatisticApi {
    override val path: String
        get() = PATH

    @Composable
    override fun StatisticPage() {
        StatisticView()
    }

    @Composable
    override fun StatisticPageWithoutScrollState() {
        StatisticViewWithoutScrollState()
    }
}
