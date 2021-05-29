package site.polaris.bangkit.skindisease.views.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import site.polaris.bangkit.skindisease.R
import site.polaris.bangkit.skindisease.databinding.FragmentResultBinding
import site.polaris.bangkit.skindisease.models.Report
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
    }

    private fun populateDummy() {
        for (i in 1..10) {
            list.add(Report("test","test"))
        }
    }
}