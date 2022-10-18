package com.example.shotaro_kumagai_stress_master.ui.stressMeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.shotaro_kumagai_stress_master.R

class SelectImage : AppCompatActivity() {
    private lateinit var selectedImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_image)
        selectedImage = findViewById(R.id.selected_image)
        val img:Int = intent.getIntExtra(SELECTED_IMAGE,65535)
        if(img != 65535){
            selectedImage.setImageResource(img)
        }
        supportActionBar?.hide()
    }

    fun onSubmit(view:View){
        finish()
    }

    fun onCancel(view: View){
        finish()
    }

    companion object{
        const val SELECTED_IMAGE = "selected_image"
    }
}