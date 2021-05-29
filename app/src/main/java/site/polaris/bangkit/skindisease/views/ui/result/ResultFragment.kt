package site.polaris.bangkit.skindisease.views.ui.result

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import site.polaris.bangkit.skindisease.R
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.views.ResultDetailActivity
import site.polaris.bangkit.skindisease.views.adapters.ReportListAdapter

class ResultFragment : Fragment() {

    private lateinit var resultViewModel: ResultViewModel
    private lateinit var rvReport: RecyclerView
    private val list = ArrayList<Report>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        resultViewModel =
                ViewModelProvider(this).get(ResultViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_result, container, false)
        
        populateDummy()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvReport = view.findViewById(R.id.rv_report)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvReport.layoutManager = LinearLayoutManager(this.context)
        val reportListAdapter = ReportListAdapter(list)
        rvReport.adapter = reportListAdapter

        reportListAdapter.setOnItemClickCallback(object : ReportListAdapter.OnItemClickCallback {
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

    private fun populateDummy() {
        var base64Img = "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"
        for (i in 1..10) {
            list.add(Report("Test",base64Img, "lorem ipsum sir dolor amet", "nani mo nai wakaranai desu",
            "03/06/2021, 11:12", "06/06/2021, 13:13"))
        }
    }
}