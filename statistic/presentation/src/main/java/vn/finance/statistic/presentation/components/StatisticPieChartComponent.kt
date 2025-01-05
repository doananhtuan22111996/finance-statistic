package vn.finance.statistic.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aay.compose.donutChart.PieChart
import com.aay.compose.donutChart.model.PieChartData
import kotlinx.coroutines.launch
import vn.finance.statistic.business.domain.model.PieChartModel
import vn.finance.statistic.business.domain.model.StatisticRecentModel
import vn.finance.statistic.presentation.R
import vn.finance.statistic.presentation.formatToDollar
import vn.finance.statistic.presentation.toColor

@Composable
fun StatisticPieChartComponent(
    incomeChart: List<PieChartModel> = listOf(),
    incomeRecent: List<StatisticRecentModel> = listOf(),
    expenseChart: List<PieChartModel> = listOf(),
    expenseRecent: List<StatisticRecentModel> = listOf(),
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(selectedTabIndex = pagerState.currentPage, tabs = {
            Tab(selected = pagerState.currentPage == 0, onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(0)
                }
            }, text = {
                Text(stringResource(R.string.income))
            })
            Tab(selected = pagerState.currentPage == 1, onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(1)
                }
            }, text = {
                Text(stringResource(R.string.expense))
            })
        })
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { _ ->
            Column {
                StatisticOverviewPager(charts = if (pagerState.currentPage == 0) incomeChart else expenseChart)
                if (pagerState.currentPage == 0) {
                    Text(
                        stringResource(R.string.recent_income),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    )
                } else {
                    Text(
                        stringResource(R.string.recent_expenses),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    )
                }
                val recent = if (pagerState.currentPage == 0) incomeRecent else expenseRecent
                recent.forEachIndexed { _, statisticRecentModel ->
                    StatisticRecentItem(
                        statisticRecentModel,
                        prefix = if (pagerState.currentPage == 0) "+" else "-",
                    )
                }
            }
        }
    }
}

@Composable
private fun StatisticOverviewPager(charts: List<PieChartModel> = listOf()) {
    val pieCharts: List<PieChartData> = charts.map {
        PieChartData(
            partName = it.name,
            data = it.money.toDouble(),
            color = it.color.toColor(),
        )
    }

    PieChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        descriptionStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurface),
        pieChartData = pieCharts,
        ratioLineColor = MaterialTheme.colorScheme.onSurface,
    )
}

@Composable
private fun StatisticRecentItem(recent: StatisticRecentModel, prefix: String = "+") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
        ) {
            Icon(
                Icons.Filled.CurrencyExchange,
                contentDescription = stringResource(R.string.currency_exchange),
                modifier = Modifier.align(Alignment.Center),
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp),
        ) {
            Text(recent.name)
            Text(recent.date, style = MaterialTheme.typography.labelSmall)
        }
        Text(
            "$prefix${recent.money.formatToDollar()}",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
        )
    }
}
