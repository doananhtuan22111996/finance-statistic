package vn.finance.statistic.presentation

import androidx.compose.ui.graphics.Color
import java.text.DecimalFormat
import java.text.NumberFormat

const val PATH = "statistic"
internal const val EMPTY_STRING = ""

fun Number.formatToDollar(): String {
    val formatter: NumberFormat = DecimalFormat("#,###.##")
    return "$${formatter.format(this)}"
}
fun String.toColor() = Color(android.graphics.Color.parseColor(this))
