package com.example.shotaro_kumagai_stress_master.ui.stressMeter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.example.shotaro_kumagai_stress_master.R

class StressMeterFragment : Fragment() {
    private lateinit var intent: Intent
    private lateinit var stressView: View
    private lateinit var myAdapter: StressAdapter
    private lateinit var stressGrid: GridView
    private lateinit var  moreImgButton: Button
    private lateinit var  images: Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        stressView = inflater.inflate(R.layout.fragment_stress_meter,container, false)
        stressGrid = stressView.findViewById<GridView>(R.id.stress_grid)
        stressGrid.onItemClickListener = AdapterView.OnItemClickListener{_,_,position,_ ->
            intent = Intent(context, SelectImage::class.java)
            intent.putExtra(SelectImage.SELECTED_IMAGE,images[position])
            intent.putExtra(SelectImage.SELECTED_STRESS, SCORE[IMAGES.indexOf(images[position])])
            startActivity(intent)
        }
        images = IMAGES.asSequence().shuffled().take(16).toList().toTypedArray()
        myAdapter = StressAdapter(stressView.context, images,16)
        stressGrid.adapter = myAdapter
        moreImgButton = stressView.findViewById(R.id.more_image)
        moreImgButton.setOnClickListener {
            images =  IMAGES.asSequence().shuffled().take(16).toList().toTypedArray()
            myAdapter = StressAdapter(stressView.context, images,16)
            stressGrid.adapter = myAdapter
        }
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
            R.drawable.psm_headache,
            R.drawable.psm_headache2,
            R.drawable.psm_hiking3,
            R.drawable.psm_kettle,
            R.drawable.psm_lake3,
            R.drawable.psm_lawn_chairs3,
            R.drawable.psm_lonely,
            R.drawable.psm_lonely2,
            R.drawable.psm_mountains11,
            R.drawable.psm_neutral_child,
            R.drawable.psm_neutral_person2,
            R.drawable.psm_peaceful_person,
            R.drawable.psm_puppy,
            R.drawable.psm_puppy3,
            R.drawable.psm_reading_in_bed2,
            R.drawable.psm_running3,
            R.drawable.psm_running4,
            R.drawable.psm_sticky_notes2,
            R.drawable.psm_stressed_person3,
            R.drawable.psm_stressed_person4,
            R.drawable.psm_stressed_person6,
            R.drawable.psm_stressed_person7,
            R.drawable.psm_stressed_person8,
            R.drawable.psm_stressed_person12,
            R.drawable.psm_talking_on_phone2,
            R.drawable.psm_to_do_list,
            R.drawable.psm_to_do_list3,
            R.drawable.psm_wine3,
            R.drawable.psm_work4,
            R.drawable.psm_yoga4
        )

        val SCORE: Array<Int> = arrayOf(
            1, 3, 3, 2, 3, 4, 1, 5, 1, 1, 4,
            1, 3, 3, 2, 3, 4, 1, 5, 1, 1, 4,
            1, 3, 3, 2, 3, 4, 1, 5, 1, 1, 4,
            1, 3, 3, 2, 3, 4, 1, 5, 1, 1, 4,
        )
    }
}