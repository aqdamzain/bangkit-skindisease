package site.polaris.bangkit.skindisease.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import site.polaris.bangkit.skindisease.Utils.base64ToBitmap

import site.polaris.bangkit.skindisease.databinding.ReportItemBinding
import site.polaris.bangkit.skindisease.models.Report

class ReportListAdapter(private val listReport: ArrayList<Report>) : RecyclerView.Adapter<ReportListAdapter.ReportListHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ReportListHolder(private val binding: ReportItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(report: Report) {
            val image = base64ToBitmap(report.image)
            with(binding) {
                imgPosterPrev.setImageBitmap(image)
                tvItemTitle.text = report.title
                tvItemDate.text = report.resultDate
            }
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
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listReport[position])
        }
    }

    override fun getItemCount(): Int = listReport.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Report)
    }
}