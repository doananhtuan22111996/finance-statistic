package vn.finance.statistic.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vn.finance.statistic.business.data.repository.GetStatisticExpenseRepositoryImpl
import vn.finance.statistic.business.data.repository.GetStatisticIncomeRepositoryImpl
import vn.finance.statistic.business.data.repository.GetStatisticRepositoryImpl
import vn.finance.statistic.business.domain.repository.GetStatisticExpenseRepository
import vn.finance.statistic.business.domain.repository.GetStatisticIncomeRepository
import vn.finance.statistic.business.domain.repository.GetStatisticRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindGetStatisticRepository(impl: GetStatisticRepositoryImpl): GetStatisticRepository

    @Binds
    abstract fun bindGetStatisticIncomeRepository(impl: GetStatisticIncomeRepositoryImpl): GetStatisticIncomeRepository

    @Binds
    abstract fun bindGetStatisticExpenseRepository(impl: GetStatisticExpenseRepositoryImpl): GetStatisticExpenseRepository
}
