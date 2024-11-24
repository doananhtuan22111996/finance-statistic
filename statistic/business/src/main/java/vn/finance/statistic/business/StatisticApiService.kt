package vn.finance.statistic.business

import retrofit2.Response
import retrofit2.http.GET
import vn.core.data.model.ObjectResponse
import vn.finance.statistic.business.data.model.StatisticRaw
import vn.finance.statistic.business.data.model.StatisticTransactionRaw

interface StatisticApiService {

    @GET("/statistic")
    suspend fun getStatistic(): Response<ObjectResponse<StatisticRaw>>

    @GET("/statistic-income")
    suspend fun getStatisticIncome(): Response<ObjectResponse<StatisticTransactionRaw>>

    @GET("/statistic-expense")
    suspend fun getStatisticExpense(): Response<ObjectResponse<StatisticTransactionRaw>>
}