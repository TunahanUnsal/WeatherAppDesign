package com.kekod.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import com.github.matteobattilana.weather.PrecipType
import com.kekod.project1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.weatherView.setWeatherData(PrecipType.RAIN)

        hideNavigationBar()

        binding.nameText.alpha = 0.2f
        binding.nameText.animate().apply {
            interpolator = LinearInterpolator()
            duration = 500
            alpha(1f)
            startDelay = 1000
            start()
        }

        binding.tempText.alpha = 0.2f
        binding.tempText.animate().apply {
            interpolator = LinearInterpolator()
            duration = 500
            alpha(1f)
            startDelay = 1000
            start()
        }


    }
    fun hideNavigationBar() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

}