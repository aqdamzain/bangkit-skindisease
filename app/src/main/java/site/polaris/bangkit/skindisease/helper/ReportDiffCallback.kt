package site.polaris.bangkit.skindisease.helper

import androidx.recyclerview.widget.DiffUtil
import site.polaris.bangkit.skindisease.models.Report

class ReportDiffCallback(private val mOldReportList: List<Report>, private val mNewReportList: List<Report>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldReportList.size
    }

    override fun getNewListSize(): Int {
        return mNewReportList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldReportList[oldItemPosition].id == mNewReportList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee = mOldReportList[oldItemPosition]
        val newEmployee = mNewReportList[newItemPosition]
        return oldEmployee.image == newEmployee.image && oldEmployee.sendDate == newEmployee.sendDate
    }
}