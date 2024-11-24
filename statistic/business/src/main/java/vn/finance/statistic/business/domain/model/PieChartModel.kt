package vn.finance.statistic.business.domain.model

import vn.core.domain.BaseModel
import vn.finance.statistic.business.EMPTY_STRING

data class PieChartModel(
    val name: String = EMPTY_STRING,
    val money: Number = 0,
    val color: String = EMPTY_STRING,
) : BaseModel()