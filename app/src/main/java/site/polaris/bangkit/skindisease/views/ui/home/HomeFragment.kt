package site.polaris.bangkit.skindisease.views.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home.*
import site.polaris.bangkit.skindisease.R
import site.polaris.bangkit.skindisease.views.adapters.ReportListAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view)
                .load(R.drawable.healthy_lifestyle)
                .into(imageView);
        Glide.with(view)
                .load(R.drawable.medical_check)
                .into(imageView2);
        Glide.with(view)
                .load(R.drawable.disease_illustration)
                .into(imageView3);
    }
}