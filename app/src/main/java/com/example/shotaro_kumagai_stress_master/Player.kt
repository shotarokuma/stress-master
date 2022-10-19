package com.example.shotaro_kumagai_stress_master

import android.app.Application
import android.media.MediaPlayer

class Player:Application(){
    lateinit var player: MediaPlayer

    companion object{
        private var instance: Player? = null
        fun getInstance(): Player{
            if (instance == null){
                instance = Player()
            }
            return instance!!
        }
    }
}