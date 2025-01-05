package vn.finance.statistic.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aay.compose.barChart.BarChart
import com.aay.compose.barChart.model.BarParameters
import vn.finance.statistic.presentation.R

@Composable
fun StatisticBarChartComponent(income: List<Number>, expense: List<Number>) {
    val charts = listOf(
        BarParameters(
            dataName = stringResource(R.string.income),
            data = income.map { it.toDouble() },
            barColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        BarParameters(
            dataName = stringResource(R.string.expense),
            data = expense.map { it.toDouble() },
            barColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
    )
    Column {
        Badge {
            Text(text = stringResource(R.string.weekly), modifier = Modifier.padding(4.dp))
        }
        Box(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
        ) {
            BarChart(
                chartParameters = charts,
                xAxisData = listOf(
                    stringResource(R.string.mon),
                    stringResource(R.string.tue),
                    stringResource(R.string.wed),
                    stringResource(R.string.thus),
                    stringResource(R.string.fri),
                    stringResource(R.string.sat),
                    stringResource(R.string.sun),
                ),
                descriptionStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurface),
                isShowGrid = true,
                animateChart = true,
                showGridWithSpacer = true,
                yAxisRange = 4,
                spaceBetweenBars = 0.dp,
                spaceBetweenGroups = 12.dp,
                barWidth = 16.dp,
                barCornerRadius = 16.dp,
                showXAxis = true,
                showYAxis = true,
            )
        }
    }
}
