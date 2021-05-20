package site.polaris.bangkit.skindisease.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import site.polaris.bangkit.skindisease.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
    }
}