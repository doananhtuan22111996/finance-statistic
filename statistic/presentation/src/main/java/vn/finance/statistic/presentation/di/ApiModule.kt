package vn.finance.statistic.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vn.finance.statistic.api.StatisticApi
import vn.finance.statistic.presentation.api.StatisticApiImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideStatisticApi(): StatisticApi = StatisticApiImpl()
}
