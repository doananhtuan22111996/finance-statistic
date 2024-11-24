package vn.finance.statistic.business.domain.model

import vn.core.domain.BaseModel

data class StatisticTransactionModel(
    val pieChart: List<PieChartModel> = listOf(),
    val recent: List<StatisticRecentModel> = listOf()
) : BaseModel()
