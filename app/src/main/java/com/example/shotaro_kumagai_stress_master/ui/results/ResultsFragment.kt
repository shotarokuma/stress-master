package com.example.shotaro_kumagai_stress_master.ui.results

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shotaro_kumagai_stress_master.MainActivity
import com.example.shotaro_kumagai_stress_master.Player
import com.example.shotaro_kumagai_stress_master.databinding.FragmentResultsBinding
import com.example.shotaro_kumagai_stress_master.ui.results.ResultsViewModel
import com.example.shotaro_kumagai_stress_master.ui.stressMeter.SelectImage

class SlideshowFragment : Fragment() {

    private lateinit var playerApp: Player
    private var _binding: FragmentResultsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(ResultsViewModel::class.java)

        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        playerApp = Player.getInstance()
        playerApp.player.stop()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}