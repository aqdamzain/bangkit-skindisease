package site.polaris.bangkit.skindisease.views.ui.result

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import site.polaris.bangkit.skindisease.R
import site.polaris.bangkit.skindisease.helper.ViewModelFactory
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.views.ResultDetailActivity
import site.polaris.bangkit.skindisease.views.adapters.ReportListAdapter

class ResultFragment : Fragment() {

    private lateinit var resultViewModel: ResultViewModel
    private lateinit var rvReport: RecyclerView
    private lateinit var adapter: ReportListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultViewModel = obtainViewModel(activity as AppCompatActivity)
        resultViewModel.getAllReports().observe(viewLifecycleOwner, reportObserver)
        rvReport = view.findViewById(R.id.rv_report)
        adapter = ReportListAdapter()
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvReport.layoutManager = LinearLayoutManager(this.context)
        rvReport.adapter = adapter

        adapter.setOnItemClickCallback(object : ReportListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Report) {
                moveToDetail(data)
            }
        })
    }

    private fun moveToDetail(data: Report) {
        val moveIntent = Intent(activity, ResultDetailActivity::class.java)
        moveIntent.putExtra(ResultDetailActivity.EXTRA_RESULT, data)
        startActivity(moveIntent)
    }

    private fun obtainViewModel(activity: AppCompatActivity): ResultViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ResultViewModel::class.java)
    }

    private val reportObserver = Observer<List<Report>> { reportList ->
        if(reportList != null) {
            adapter.setListReports(reportList)
        }
    }
}