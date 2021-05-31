package site.polaris.bangkit.skindisease

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_process.*
import site.polaris.bangkit.skindisease.Utils.base64ToBitmap
import site.polaris.bangkit.skindisease.views.MainActivity

class ProcessActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CAMERA_RESULT = "extra_camera_result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_process)

        val cameraResult = intent.getStringExtra(EXTRA_CAMERA_RESULT)

        iv_preview.setImageBitmap(base64ToBitmap(cameraResult))

        button.setOnClickListener{
            val intent = Intent(this@ProcessActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}