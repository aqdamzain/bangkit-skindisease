package site.polaris.bangkit.skindisease.models.local

import androidx.lifecycle.LiveData
import androidx.room.*
import site.polaris.bangkit.skindisease.models.Report

@Dao
interface ReportDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(report: Report)

    @Update
    fun update(report: Report)

    @Delete
    fun delete(report: Report)

    @Query("SELECT * from report ORDER BY id ASC")
    fun getAllReports(): LiveData<List<Report>>

}