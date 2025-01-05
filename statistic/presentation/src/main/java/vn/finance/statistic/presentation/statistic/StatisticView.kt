package vn.finance.statistic.presentation.statistic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import vn.core.composex.uikit.alert.AlertExceptionDialogComponent
import vn.core.composex.uikit.loading.FullScreenLoadingDialogComponent
import vn.core.domain.ResultModel
import vn.finance.statistic.business.domain.model.StatisticModel
import vn.finance.statistic.business.domain.model.StatisticTransactionModel
import vn.finance.statistic.presentation.R
import vn.finance.statistic.presentation.components.IncomeExpenseComponent
import vn.finance.statistic.presentation.components.StatisticBarChartComponent
import vn.finance.statistic.presentation.components.StatisticPieChartComponent

@Composable
fun StatisticView() {
    val viewModel: StatisticViewModel = hiltViewModel()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val appException by viewModel.appException.collectAsStateWithLifecycle()
    val statistic by viewModel.statistic.collectAsStateWithLifecycle()
    val income by viewModel.income.collectAsStateWithLifecycle()
    val expense by viewModel.expense.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        StatisticContainer(
            statistic = statistic,
            income = income,
            expense = expense,
            isLoading = isLoading,
            appException = appException,
            onDismissRequest = {
                viewModel.dismissAppException()
            },
        )
    }
}

@Composable
fun StatisticViewWithoutScrollState() {
    val viewModel: StatisticViewModel = hiltViewModel()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val appException by viewModel.appException.collectAsStateWithLifecycle()
    val statistic by viewModel.statistic.collectAsStateWithLifecycle()
    val income by viewModel.income.collectAsStateWithLifecycle()
    val expense by viewModel.expense.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        StatisticContainer(
            statistic = statistic,
            income = income,
            expense = expense,
            isLoading = isLoading,
            appException = appException,
            onDismissRequest = {
                viewModel.dismissAppException()
            },
        )
    }
}

@Composable
private fun StatisticContainer(
    statistic: StatisticModel?,
    income: StatisticTransactionModel?,
    expense: StatisticTransactionModel?,
    isLoading: Boolean,
    appException: ResultModel.AppException?,
    onDismissRequest: () -> Unit,
) {
    if (statistic != null && income != null && expense != null) {
        IncomeExpenseComponent(
            income = statistic.totalIncome,
            statistic.totalExpense,
        )
        Box(modifier = Modifier.padding(vertical = 24.dp)) {
            StatisticBarChartComponent(
                income = statistic.barChart.income,
                expense = statistic.barChart.expense,
            )
        }
        StatisticPieChartComponent(
            incomeChart = income.pieChart,
            incomeRecent = income.recent,
            expenseChart = expense.pieChart,
            expenseRecent = expense.recent,
        )
    }

    if (isLoading) {
        FullScreenLoadingDialogComponent()
    }

    if (appException != null) {
        AlertExceptionDialogComponent(
            message = stringResource(R.string.we_couldn_t_fetch_your_data_right_now_please_check_your_internet_connection_and_try_again_if_the_issue_persists_contact_support_for_assistance),
            onDismissRequest = onDismissRequest,
        )
    }
}
