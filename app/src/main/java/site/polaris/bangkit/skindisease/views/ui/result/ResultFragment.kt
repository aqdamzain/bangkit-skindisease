package site.polaris.bangkit.skindisease.views.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import site.polaris.bangkit.skindisease.R

class ResultFragment : Fragment() {

    private lateinit var resultViewModel: ResultViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        resultViewModel =
                ViewModelProvider(this).get(ResultViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_result, container, false)
        val textView: TextView = root.findViewById(R.id.text_result)
        resultViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}