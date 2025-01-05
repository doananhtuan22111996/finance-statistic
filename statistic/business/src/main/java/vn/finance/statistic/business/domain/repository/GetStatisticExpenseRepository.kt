package vn.finance.statistic.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.finance.statistic.business.domain.model.StatisticTransactionModel

interface GetStatisticExpenseRepository {
    fun getStatisticExpense(): Flow<ResultModel<StatisticTransactionModel>>
}
