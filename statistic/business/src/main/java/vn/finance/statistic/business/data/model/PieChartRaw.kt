package vn.finance.statistic.business.data.model

import vn.core.data.model.BaseRaw
import vn.finance.statistic.business.EMPTY_STRING
import vn.finance.statistic.business.domain.model.PieChartModel

data class PieChartRaw(
    val name: String? = null,
    val money: Number? = null,
    val color: String? = null,
) : BaseRaw() {
    override fun raw2Model(): PieChartModel = PieChartModel(
        name = name ?: EMPTY_STRING,
        money = money ?: 0,
        color = color ?: EMPTY_STRING,
    )
}
