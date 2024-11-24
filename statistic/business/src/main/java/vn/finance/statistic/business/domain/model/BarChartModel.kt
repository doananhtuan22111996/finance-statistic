package vn.finance.statistic.business.domain.model

import vn.core.domain.BaseModel

data class BarChartModel(
    val income: List<Int> = listOf(),
    val expense: List<Int> = listOf(),
) : BaseModel()