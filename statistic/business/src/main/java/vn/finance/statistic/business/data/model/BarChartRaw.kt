package vn.finance.statistic.business.data.model

import vn.core.data.model.BaseRaw
import vn.finance.statistic.business.domain.model.BarChartModel

data class BarChartRaw(
    val income: List<Int>? = null,
    val expense: List<Int>? = null,
) : BaseRaw() {
    override fun raw2Model(): BarChartModel {
        return BarChartModel(
            income = income?.map { it } ?: listOf(),
            expense = expense?.map { it } ?: listOf(),
        )
    }
}
