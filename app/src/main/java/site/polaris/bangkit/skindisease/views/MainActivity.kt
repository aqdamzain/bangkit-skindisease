package site.polaris.bangkit.skindisease.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import site.polaris.bangkit.skindisease.R
import site.polaris.bangkit.skindisease.databinding.ActivityMainBinding
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.views.adapters.ReportListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Report>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvReport.setHasFixedSize(true)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        populateDummy()
        showRecyclerList()


    }

    private fun showRecyclerList() {
        binding.rvReport.layoutManager = LinearLayoutManager(this)
        val reportListAdapter = ReportListAdapter(list)
        binding.rvReport.adapter = reportListAdapter
    }

    private fun populateDummy() {
        for (i in 1..10) {
            list.add(Report("test","test"))
        }
    }
}