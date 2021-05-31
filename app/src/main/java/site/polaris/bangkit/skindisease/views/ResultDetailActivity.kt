package site.polaris.bangkit.skindisease.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import site.polaris.bangkit.skindisease.Utils.base64ToBitmap
import site.polaris.bangkit.skindisease.databinding.ActivityResultDetailBinding
import site.polaris.bangkit.skindisease.models.Report

class ResultDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultDetailBinding
    companion object {
        const val EXTRA_RESULT = "extra_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getParcelableExtra<Report>(EXTRA_RESULT) as Report
        populateView(result)

    }

    private fun populateView(data: Report) {
        val image = base64ToBitmap(data.image)
        with(binding) {
            ivDetail.setImageBitmap(image)
            tvSDate.text = data.sendDate
            tvRDate.text = data.resultDate
            tvRName.text = data.title
            tvDescription.text = data.description
            tvSuggestion.text = data.suggestion
        }
    }
}