package site.polaris.bangkit.skindisease.views.ui.result

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.repository.ReportRepository

class ResultViewModel(application: Application) : ViewModel() {

    private val mReportRepository: ReportRepository = ReportRepository(application)

    fun getAllReports(): LiveData<List<Report>> = mReportRepository.getAllReports()
}