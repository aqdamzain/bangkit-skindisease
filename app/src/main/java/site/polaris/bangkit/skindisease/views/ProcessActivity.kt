package site.polaris.bangkit.skindisease.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import site.polaris.bangkit.skindisease.Utils.base64ToBitmap
import site.polaris.bangkit.skindisease.databinding.ActivityProcessBinding
import site.polaris.bangkit.skindisease.helper.DateHelper
import site.polaris.bangkit.skindisease.helper.ViewModelFactory
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.models.remote.ReportRequest
import site.polaris.bangkit.skindisease.models.remote.ReportResponse


class ProcessActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CAMERA_RESULT = "extra_camera_result"
    }

    private lateinit var binding: ActivityProcessBinding

    private var report: Report? = null

    private lateinit var processViewModel: ProcessViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cameraResult = intent.getStringExtra(EXTRA_CAMERA_RESULT)

        processViewModel = obtainViewModel(this@ProcessActivity)

        binding.ivPreview.setImageBitmap(base64ToBitmap(cameraResult))

        binding.cancelButton.visibility = View.VISIBLE
        binding.sendButton.visibility = View.VISIBLE
        binding.detailButton.visibility = View.GONE
        binding.progressbar.visibility = View.GONE
        binding.tvLoading.visibility= View.GONE

        binding.sendButton.setOnClickListener{
            binding.ivPreview.visibility = View.GONE
            binding.progressbar.visibility = View.VISIBLE
            binding.tvLoading.visibility= View.VISIBLE
            processViewModel.postFeatures(ReportRequest(cameraResult)).observe(this,
                    { response ->
                        if (response != null) {
                            binding.ivPreview.visibility = View.VISIBLE
                            binding.cancelButton.visibility = View.GONE
                            binding.sendButton.visibility = View.GONE
                            binding.detailButton.visibility = View.VISIBLE
                            binding.progressbar.visibility = View.GONE
                            binding.tvLoading.visibility= View.GONE
                            report?.title = response.disease
                            report?.description = response.description
                            report?.suggestion = response.suggestion
                            report?.resultDate = DateHelper.getCurrentDate()

                            processViewModel.insert(report as Report)
                        }
                    })
        }
        report = Report()

        report.let { report ->
            report?.image = cameraResult
            report?.sendDate = DateHelper.getCurrentDate()
        }


        binding.cancelButton.setOnClickListener{
            val intent = Intent(this@ProcessActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.detailButton.setOnClickListener{
            val intent = Intent(this@ProcessActivity, MainActivity::class.java)
            startActivity(intent)
        }
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