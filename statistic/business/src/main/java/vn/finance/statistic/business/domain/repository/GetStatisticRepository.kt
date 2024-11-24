package vn.finance.statistic.business.domain.repository

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.finance.statistic.business.domain.model.StatisticModel

interface GetStatisticRepository {
    fun getStatistic(): Flow<ResultModel<StatisticModel>>
}