package vn.finance.statistic.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vn.finance.statistic.business.domain.repository.GetStatisticExpenseRepository
import vn.finance.statistic.business.domain.repository.GetStatisticIncomeRepository
import vn.finance.statistic.business.domain.repository.GetStatisticRepository
import vn.finance.statistic.business.domain.usecase.GetStatisticExpenseUseCase
import vn.finance.statistic.business.domain.usecase.GetStatisticIncomeUseCase
import vn.finance.statistic.business.domain.usecase.GetStatisticUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetStatisticUseCase(repository: GetStatisticRepository): GetStatisticUseCase {
        return GetStatisticUseCase(repository)
    }

    @Provides
    fun provideGetStatisticIncomeUseCase(repository: GetStatisticIncomeRepository): GetStatisticIncomeUseCase {
        return GetStatisticIncomeUseCase(repository)
    }

    @Provides
    fun provideGetStatisticExpenseUseCase(repository: GetStatisticExpenseRepository): GetStatisticExpenseUseCase {
        return GetStatisticExpenseUseCase(repository)
    }
}