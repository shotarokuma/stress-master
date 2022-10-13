package com.example.shotaro_kumagai_stress_master.ui.stressMeter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.shotaro_kumagai_stress_master.R


class StressAdapter(
    private val context: Context,
    private val imgData: Array<Int>,
    private val count: Int,
): BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var imgView: ImageView
    override fun getCount(): Int {
        return count
    }
    override fun getItem(p0: Int): Any? {
        return null
    }
    override fun getItemId(p0: Int): Long {
        return 0
    }
    override fun getView(
        position: Int,
        target: View?,
        parent: ViewGroup?
    ): View {
        var target = target
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if(target == null){
            target = layoutInflater!!.inflate(R.layout.stress_img, null)
        }
        imgView = target!!.findViewById(R.id.stress_img)
        imgView.setImageResource(imgData[position])
        return target
    }
}