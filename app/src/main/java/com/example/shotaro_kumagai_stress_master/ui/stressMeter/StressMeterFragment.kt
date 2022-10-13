package com.example.shotaro_kumagai_stress_master.ui.stressMeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shotaro_kumagai_stress_master.databinding.FragmentStressMeterBinding

class StressMeterFragment : Fragment() {

    private var _binding: FragmentStressMeterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val stressMeterViewModel =
            ViewModelProvider(this).get(StressMeterViewModel::class.java)

        _binding = FragmentStressMeterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        stressMeterViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}