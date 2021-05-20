package site.polaris.bangkit.skindisease.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import site.polaris.bangkit.skindisease.databinding.ReportItemBinding
import site.polaris.bangkit.skindisease.models.Report

class ReportListAdapter(private val listReport: ArrayList<Report>) : RecyclerView.Adapter<ReportListAdapter.ReportListHolder>() {
    inner class ReportListHolder(private val binding: ReportItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(report: Report) {

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReportListAdapter.ReportListHolder {
        val binding = ReportItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReportListHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportListAdapter.ReportListHolder, position: Int) {
        holder.bind(listReport[position])
    }

    override fun getItemCount(): Int = listReport.size
}