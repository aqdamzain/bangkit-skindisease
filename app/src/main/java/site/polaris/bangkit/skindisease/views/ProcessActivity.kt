package site.polaris.bangkit.skindisease.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_process.*
import site.polaris.bangkit.skindisease.R
import site.polaris.bangkit.skindisease.Utils.base64ToBitmap
import site.polaris.bangkit.skindisease.helper.DateHelper
import site.polaris.bangkit.skindisease.helper.ViewModelFactory
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.models.remote.ReportRequest
import site.polaris.bangkit.skindisease.models.remote.ReportResponse


class ProcessActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CAMERA_RESULT = "extra_camera_result"
    }

    private var report: Report? = null

    private lateinit var processViewModel: ProcessViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)

        val cameraResult = intent.getStringExtra(EXTRA_CAMERA_RESULT)

        processViewModel = obtainViewModel(this@ProcessActivity)
        processViewModel.postFeatures(ReportRequest(cameraResult)).observe(this,
            object : Observer<ReportResponse?> {
                override fun onChanged(response: ReportResponse?) {
                    if(response != null){
                        report?.title = response.disease
                        report?.description = response.description
                        report?.suggestion = response.suggestion
                        report?.resultDate = DateHelper.getCurrentDate()

                        processViewModel.insert(report as Report)
                    }
                }
            })
        report = Report()

        report.let { report ->
            report?.image = cameraResult
            report?.sendDate = DateHelper.getCurrentDate()
        }


        button.setOnClickListener{
            val intent = Intent(this@ProcessActivity, MainActivity::class.java)
            startActivity(intent)
        }

        iv_preview.setImageBitmap(base64ToBitmap(report?.image))
        textView2.text = report?.sendDate
    }

    private fun obtainViewModel(activity: AppCompatActivity): ProcessViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ProcessViewModel::class.java)
    }

    private val responseObserver = Observer<ReportResponse> { response ->
        if(response != null){
            report?.title = response.disease
            report?.description = response.description
            report?.suggestion = response.suggestion
            report?.resultDate = DateHelper.getCurrentDate()

            processViewModel.insert(report as Report)
        }
    }
}