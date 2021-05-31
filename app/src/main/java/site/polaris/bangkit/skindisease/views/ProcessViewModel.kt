package site.polaris.bangkit.skindisease.views

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.models.remote.ReportRequest
import site.polaris.bangkit.skindisease.models.remote.ReportResponse
import site.polaris.bangkit.skindisease.repository.RemoteReportRepository
import site.polaris.bangkit.skindisease.repository.ReportRepository

class ProcessViewModel(application: Application) : ViewModel() {
    private val mReportRepository: ReportRepository = ReportRepository(application)
    private val mRemoteReportRepository: RemoteReportRepository = RemoteReportRepository()

    fun insert(report: Report) {
        mReportRepository.insert(report)
    }

    fun postFeatures(data: ReportRequest): LiveData<ReportResponse> {
        return mRemoteReportRepository.postFeatures(data)
    }

}