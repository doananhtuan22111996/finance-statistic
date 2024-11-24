package vn.finance.statistic.business.domain.model

import vn.core.domain.BaseModel

data class StatisticModel(
    val totalIncome: Number = 0,
    val totalExpense: Number = 0,
    val barChart: BarChartModel = BarChartModel()
) : BaseModel()
