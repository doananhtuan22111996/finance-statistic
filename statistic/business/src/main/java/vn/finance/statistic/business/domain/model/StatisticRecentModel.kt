package vn.finance.statistic.business.domain.model

import vn.core.domain.BaseModel
import vn.finance.statistic.business.EMPTY_STRING

data class StatisticRecentModel(
    val id: Int = -1,
    val name: String = EMPTY_STRING,
    val money: Number = 0,
    val date: String = EMPTY_STRING
) : BaseModel()
