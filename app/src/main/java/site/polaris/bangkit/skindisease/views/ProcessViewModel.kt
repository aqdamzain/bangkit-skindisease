package site.polaris.bangkit.skindisease.views

import android.app.Application
import androidx.lifecycle.ViewModel
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.repository.ReportRepository

class ProcessViewModel(application: Application) : ViewModel() {
    private val mReportRepository: ReportRepository = ReportRepository(application)

    fun insert(report: Report) {
        mReportRepository.insert(report)
    }

}