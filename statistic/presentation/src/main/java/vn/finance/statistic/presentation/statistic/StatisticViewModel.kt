package vn.finance.statistic.presentation.statistic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import vn.core.domain.ResultModel
import vn.finance.statistic.business.domain.model.StatisticModel
import vn.finance.statistic.business.domain.model.StatisticTransactionModel
import vn.finance.statistic.business.domain.usecase.GetStatisticExpenseUseCase
import vn.finance.statistic.business.domain.usecase.GetStatisticIncomeUseCase
import vn.finance.statistic.business.domain.usecase.GetStatisticUseCase
import javax.inject.Inject

@HiltViewModel
class StatisticViewModel @Inject constructor(
    private val getStatisticUseCase: GetStatisticUseCase,
    private val getStatisticIncomeUseCase: GetStatisticIncomeUseCase,
    private val getStatisticExpenseUseCase: GetStatisticExpenseUseCase,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()
    private val _appException = MutableStateFlow<ResultModel.AppException?>(null)
    val appException = _appException.asStateFlow()
    private val _statistic = MutableStateFlow<StatisticModel?>(null)
    val statistic = _statistic.asStateFlow()
    private val _income = MutableStateFlow<StatisticTransactionModel?>(null)
    val income = _income.asStateFlow()
    private val _expense = MutableStateFlow<StatisticTransactionModel?>(null)
    val expense = _expense.asStateFlow()

    init {
        getStatistic()
    }

    fun dismissAppException() {
        viewModelScope.launch {
            _appException.value = null
        }
    }

    private fun getStatistic() {
        viewModelScope.launch {
            combine(
                getStatisticUseCase.execute(),
                getStatisticIncomeUseCase.execute(),
                getStatisticExpenseUseCase.execute(),
            ) { statistic, statisticIncome, statisticExpense ->
                if (statistic is ResultModel.Success) {
                    _statistic.value = statistic.data
                } else if (statistic is ResultModel.AppException) {
                    _appException.value = statistic
                }
                if (statisticIncome is ResultModel.Success) {
                    _income.value = statisticIncome.data
                } else if (statisticIncome is ResultModel.AppException) {
                    _appException.value = statisticIncome
                }
                if (statisticExpense is ResultModel.Success) {
                    _expense.value = statisticExpense.data
                } else if (statisticExpense is ResultModel.AppException) {
                    _appException.value = statisticExpense
                }
            }.onStart {
                _isLoading.value = true
            }.onCompletion {
                _isLoading.value = false
            }.collect {
                // Do nothing
            }
        }
    }
}
