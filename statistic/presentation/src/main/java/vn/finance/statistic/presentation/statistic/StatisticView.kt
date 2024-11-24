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
import vn.finance.statistic.presentation.R
import vn.finance.statistic.presentation.components.AlertExceptionDialogComponent
import vn.finance.statistic.presentation.components.FullScreenLoadingDialogComponent
import vn.finance.statistic.presentation.components.IncomeExpenseComponent
import vn.finance.statistic.presentation.components.StatisticBarChartComponent
import vn.finance.statistic.presentation.components.StatisticPieChartComponent

@Composable
fun StatisticView(modifier: Modifier) {
    val viewModel: StatisticViewModel = hiltViewModel()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val appException by viewModel.appException.collectAsStateWithLifecycle()
    val statistic by viewModel.statistic.collectAsStateWithLifecycle()
    val income by viewModel.income.collectAsStateWithLifecycle()
    val expense by viewModel.expense.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        if (statistic != null && income != null && expense != null) {
            IncomeExpenseComponent(
                income = statistic?.totalIncome ?: 0, statistic?.totalExpense ?: 0
            )
            Box(modifier = Modifier.padding(vertical = 24.dp)) {
                StatisticBarChartComponent(
                    income = statistic?.barChart?.income ?: listOf(),
                    expense = statistic?.barChart?.expense ?: listOf()
                )
            }
            StatisticPieChartComponent(
                incomeChart = income?.pieChart ?: listOf(),
                incomeRecent = income?.recent ?: listOf(),
                expenseChart = expense?.pieChart ?: listOf(),
                expenseRecent = expense?.recent ?: listOf()
            )
        }

        if (isLoading) {
            FullScreenLoadingDialogComponent()
        }

        if (appException != null) {
            AlertExceptionDialogComponent(message = stringResource(R.string.we_couldn_t_fetch_your_data_right_now_please_check_your_internet_connection_and_try_again_if_the_issue_persists_contact_support_for_assistance),
                onDismissRequest = { viewModel.dismissAppException() })
        }
    }
}