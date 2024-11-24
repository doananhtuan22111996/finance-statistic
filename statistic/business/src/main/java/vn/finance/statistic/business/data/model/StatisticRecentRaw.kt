package vn.finance.statistic.business.data.model

import vn.core.data.model.BaseRaw
import vn.finance.statistic.business.EMPTY_STRING
import vn.finance.statistic.business.domain.model.StatisticRecentModel

data class StatisticRecentRaw(
    val id: Int?, val name: String?, val money: Number?, val date: String?
) : BaseRaw() {
    override fun raw2Model(): StatisticRecentModel {
        return StatisticRecentModel(
            id = id ?: 0,
            name = name ?: EMPTY_STRING,
            money = money ?: 0,
            date = date ?: EMPTY_STRING
        )
    }
}
