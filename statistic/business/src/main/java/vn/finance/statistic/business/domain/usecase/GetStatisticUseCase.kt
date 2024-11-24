package vn.finance.statistic.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import vn.core.domain.ResultModel
import vn.core.usecase.BaseUseCase
import vn.finance.statistic.business.domain.model.StatisticModel
import vn.finance.statistic.business.domain.repository.GetStatisticRepository
import javax.inject.Inject

class GetStatisticUseCase @Inject constructor(private val repository: GetStatisticRepository) :
    BaseUseCase<Unit, ResultModel<StatisticModel>>() {
    override fun execute(vararg params: Unit?): Flow<ResultModel<StatisticModel>> {
        return repository.getStatistic()
    }
}