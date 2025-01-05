package vn.finance.statistic.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.statistic.business.domain.model.StatisticTransactionModel
import vn.finance.statistic.business.domain.repository.GetStatisticIncomeRepository
import javax.inject.Inject

class GetStatisticIncomeUseCase @Inject constructor(private val repository: GetStatisticIncomeRepository) : BaseUseCase<Unit, ResultModel<StatisticTransactionModel>>() {
    override fun execute(vararg params: Unit?): Flow<ResultModel<StatisticTransactionModel>> = repository.getStatisticIncome()
}
