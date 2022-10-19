package com.example.shotaro_kumagai_stress_master

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.shotaro_kumagai_stress_master.databinding.ActivityMainBinding
import com.example.shotaro_kumagai_stress_master.ui.stressMeter.SelectImage

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var playerApp: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_stressMeter, R.id.nav_results
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        playerApp = Player.getInstance()
        playerApp.player = MediaPlayer.create(this, R.raw.notification)
        playerApp.player.isLooping = true
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences(SelectImage.PREF,Context.MODE_PRIVATE)
        val notification = sharedPref.getBoolean(SelectImage.NOTIFICATION, false)
        if (notification){
            playerApp.player.start()
            sharedPref.edit().remove(SelectImage.PREF).apply()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}