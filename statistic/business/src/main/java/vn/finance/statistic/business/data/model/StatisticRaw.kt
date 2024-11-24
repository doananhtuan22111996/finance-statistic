package vn.finance.statistic.business.data.model

import vn.core.data.model.BaseRaw
import vn.finance.statistic.business.domain.model.BarChartModel
import vn.finance.statistic.business.domain.model.StatisticModel

data class StatisticRaw(
    val totalIncome: Number? = null,
    val totalExpense: Number? = null,
    val barChart: BarChartRaw? = null
) : BaseRaw() {
    override fun raw2Model(): StatisticModel {
        return StatisticModel(
            totalExpense = totalExpense ?: 0,
            totalIncome = totalIncome ?: 0,
            barChart = barChart?.raw2Model() ?: BarChartModel()
        )
    }
}
