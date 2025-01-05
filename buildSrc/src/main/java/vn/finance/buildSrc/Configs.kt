package vn.finance.buildSrc

object Configs {

    object BuildModule {
        const val STATISTIC_PRESENTATION = ":statistic:presentation"
        const val STATISTIC_BUSINESS = ":statistic:business"
        const val STATISTIC_API = ":statisticApi"
    }

    object Statistic {
        const val BUSINESS_NAMESPACE = "vn.finance.statistic.business"
        const val PRESENTATION_NAMESPACE = "vn.finance.statistic.presentation"
        const val API_NAMESPACE = "vn.finance.statistic.api"
    }

    object Demo {
        const val NAMESPACE = "vn.finance.demo"
        const val APPLICATION_ID = "vn.finance.demo"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
    }

    object Artifact {
        const val GROUP_ID = "vn.finance.libs"
        const val ARTIFACT_PRESENTATION_ID = "feature-statistic-presentation"
        const val ARTIFACT_BUSINESS_ID = "feature-statistic-business"
        const val ARTIFACT_API_ID = "feature-statistic-api"
        const val VERSION = "1.0.4"
    }
}
