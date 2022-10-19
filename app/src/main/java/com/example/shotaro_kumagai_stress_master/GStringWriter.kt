package com.example.shotaro_kumagai_stress_master

import android.app.Application
import java.io.StringWriter

class GStringWriter:Application() {
    val stringWriter: StringWriter = StringWriter()

    companion object{
        private var instance: GStringWriter? = null
        fun getInstance(): GStringWriter{
            if (instance == null){
                instance = GStringWriter()
            }
            return instance!!
        }
    }
}