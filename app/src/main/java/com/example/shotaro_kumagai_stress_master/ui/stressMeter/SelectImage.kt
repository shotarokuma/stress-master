package com.example.shotaro_kumagai_stress_master.ui.stressMeter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.shotaro_kumagai_stress_master.GStringWriter
import com.example.shotaro_kumagai_stress_master.R
import com.opencsv.CSVWriter
import java.io.StringWriter
import kotlin.system.exitProcess

class SelectImage : AppCompatActivity() {
    private lateinit var selectedImage: ImageView
    private lateinit var  csvWrite:CSVWriter
    private lateinit var  time : Number
    private lateinit var  stress: Number
    private lateinit var stringWriter: StringWriter

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
        val gStringWriter: GStringWriter =  GStringWriter.getInstance()
        stringWriter = gStringWriter.stringWriter
        csvWrite = CSVWriter(stringWriter)
        time = System.currentTimeMillis()/1000
        stress = intent.getIntExtra(SELECTED_STRESS, 65535)
        csvWrite.writeNext(arrayOf(time.toString(), stress.toString()))

        val sharedPref = getSharedPreferences(PREF ,Context.MODE_PRIVATE)
        sharedPref.edit().putBoolean(NOTIFICATION,true).apply()
        moveTaskToBack(true)
        finishAndRemoveTask()
    }

    fun onCancel(view: View){
        finish()
    }

    companion object{
        const val SELECTED_IMAGE = "selected_image"
        const val SELECTED_STRESS = "selected_stress"
        const val NOTIFICATION = "notification"
        const val PREF = "preference"
    }
}