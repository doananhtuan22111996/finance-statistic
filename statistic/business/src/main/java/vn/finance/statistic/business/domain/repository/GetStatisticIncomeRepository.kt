package vn.finance.statistic.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.finance.statistic.business.domain.model.StatisticTransactionModel

interface GetStatisticIncomeRepository {
    fun getStatisticIncome(): Flow<ResultModel<StatisticTransactionModel>>
}
