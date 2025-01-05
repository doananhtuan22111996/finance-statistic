package vn.finance.statistic.business.data.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import vn.core.data.di.AnoRetrofitApiService
import vn.core.data.model.ObjectResponse
import vn.core.data.network.NetworkBoundService
import vn.core.domain.ResultModel
import vn.finance.statistic.business.StatisticApiService
import vn.finance.statistic.business.data.model.StatisticTransactionRaw
import vn.finance.statistic.business.domain.model.StatisticTransactionModel
import vn.finance.statistic.business.domain.repository.GetStatisticExpenseRepository
import javax.inject.Inject

class GetStatisticExpenseRepositoryImpl @Inject constructor(@AnoRetrofitApiService private val apiService: StatisticApiService) : GetStatisticExpenseRepository {

    override fun getStatisticExpense(): Flow<ResultModel<StatisticTransactionModel>> = object : NetworkBoundService<StatisticTransactionRaw, StatisticTransactionModel>() {
        override suspend fun onApi(): Response<ObjectResponse<StatisticTransactionRaw>> = apiService.getStatisticExpense()

        override suspend fun processResponse(request: ObjectResponse<StatisticTransactionRaw>?): ResultModel.Success<StatisticTransactionModel> = ResultModel.Success(
            data = request?.data?.raw2Model() ?: StatisticTransactionModel(),
        )
    }.build()
}
