package site.polaris.bangkit.skindisease.repository

import android.app.Application
import androidx.lifecycle.LiveData
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.models.local.ReportDao
import site.polaris.bangkit.skindisease.models.local.ReportRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ReportRepository(application: Application) {

    private val mReportDao: ReportDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = ReportRoomDatabase.getDatabase(application)
        mReportDao = db.reportDao()
    }

    fun getAllReports(): LiveData<List<Report>> = mReportDao.getAllReports()

    fun insert(report: Report) {
        executorService.execute { mReportDao.insert(report) }
    }
}