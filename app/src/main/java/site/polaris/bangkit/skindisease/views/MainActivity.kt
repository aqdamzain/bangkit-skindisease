package site.polaris.bangkit.skindisease.views

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import site.polaris.bangkit.skindisease.R
import site.polaris.bangkit.skindisease.databinding.ActivityMainBinding
import site.polaris.bangkit.skindisease.models.Report
import site.polaris.bangkit.skindisease.views.adapters.ReportListAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        private const val CAMERA_REQUEST_CODE = 2
    }

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Report>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        populateMenu()
        populateDummy()




    }

    private fun populateDummy() {
        for (i in 1..10) {
            list.add(Report("test","test"))
        }
    }

    private fun populateMenu() {
        fab_cam.setOnClickListener {
            if(ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }else{
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_REQUEST_CODE)
            }else{
                Toast.makeText(
                    this,
                    "Oops you just denied the permission for camera. " +
                            "Don't worry you can allow it in the settings.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}