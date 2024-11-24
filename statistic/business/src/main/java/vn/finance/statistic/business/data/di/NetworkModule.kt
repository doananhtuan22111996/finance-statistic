package vn.finance.statistic.business.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import vn.core.data.di.AnoRetrofitApiService
import vn.core.data.di.ProviderModule.provideRetrofit
import vn.core.provider.finance.Configs
import vn.finance.statistic.business.StatisticApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    @AnoRetrofitApiService
    fun provideApiServices(
        okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory
    ): StatisticApiService {
        return provideRetrofit<StatisticApiService>(
            baseUrl = Configs.MAIN_DOMAIN,
            okHttpClient = okHttpClient,
            gsonConverterFactory = gsonConverterFactory
        )
    }
}