package vn.finance.statistic.business.data.model

import vn.core.data.model.BaseRaw
import vn.finance.statistic.business.domain.model.StatisticTransactionModel

data class StatisticTransactionRaw(
    val pieChart: List<PieChartRaw>? = null,
    val recent: List<StatisticRecentRaw>? = null,
) : BaseRaw() {
    override fun raw2Model(): StatisticTransactionModel {
        return StatisticTransactionModel(
            pieChart = pieChart?.map { it.raw2Model() } ?: listOf(),
            recent = recent?.map { it.raw2Model() } ?: listOf(),
        )
    }
}