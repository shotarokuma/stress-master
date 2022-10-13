package com.example.shotaro_kumagai_stress_master.ui.stressMeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.shotaro_kumagai_stress_master.R

class StressMeterFragment : Fragment() {
    private lateinit var stressView: View
    private lateinit var myAdapter: StressAdapter
    private lateinit var stressGrid: GridView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        stressView = inflater.inflate(R.layout.fragment_stress_meter,container, false)
        stressGrid = stressView.findViewById<GridView>(R.id.stress_grid)
        myAdapter = StressAdapter(stressView.context, IMAGES,16)
        stressGrid.adapter = myAdapter
        return stressView
    }

    companion object{
        val IMAGES:Array<Int> = arrayOf(
            R.drawable.psm_alarm_clock,
            R.drawable.psm_alarm_clock2,
            R.drawable.psm_angry_face,
            R.drawable.psm_anxious,
            R.drawable.psm_baby_sleeping,
            R.drawable.psm_bar,
            R.drawable.psm_barbed_wire2,
            R.drawable.psm_beach3,
            R.drawable.psm_bird3,
            R.drawable.psm_blue_drop,
            R.drawable.psm_cat,
            R.drawable.psm_clutter,
            R.drawable.psm_dog_sleeping,
            R.drawable.psm_exam4,
            R.drawable.psm_gambling4,
            R.drawable.psm_puppy
        )

        val SCORE: Array<Int> = arrayOf(1, 3, 3, 2, 3, 4, 1, 5, 1, 1, 4, 5, 5, 3, 3)
    }
}