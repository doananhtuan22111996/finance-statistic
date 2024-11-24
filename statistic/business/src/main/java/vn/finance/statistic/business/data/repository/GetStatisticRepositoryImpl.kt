package vn.finance.statistic.business.data.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import vn.core.data.di.AnoRetrofitApiService
import vn.core.data.model.ObjectResponse
import vn.core.data.network.NetworkBoundService
import vn.core.domain.ResultModel
import vn.finance.statistic.business.StatisticApiService
import vn.finance.statistic.business.data.model.StatisticRaw
import vn.finance.statistic.business.domain.model.StatisticModel
import vn.finance.statistic.business.domain.repository.GetStatisticRepository
import javax.inject.Inject

class GetStatisticRepositoryImpl @Inject constructor(@AnoRetrofitApiService private val apiService: StatisticApiService) :
    GetStatisticRepository {
    override fun getStatistic(): Flow<ResultModel<StatisticModel>> =
        object : NetworkBoundService<StatisticRaw, StatisticModel>() {
            override suspend fun onApi(): Response<ObjectResponse<StatisticRaw>> {
                return apiService.getStatistic()
            }

            override suspend fun processResponse(request: ObjectResponse<StatisticRaw>?): ResultModel.Success<StatisticModel> {
                return ResultModel.Success(data = request?.data?.raw2Model() ?: StatisticModel())
            }
        }.build()
}