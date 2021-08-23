package com.kekod.project1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.github.matteobattilana.weather.PrecipType
import com.kekod.project1.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding!!.weatherView.setWeatherData(PrecipType.SNOW)


        binding!!.nameText.alpha = 0.2f
        binding!!.nameText.animate().apply {
            interpolator = LinearInterpolator()
            duration = 1000
            alpha(1f)
            startDelay = 1000
            start()
        }

        binding!!.tempText.alpha = 0.2f
        binding!!.tempText.animate().apply {
            interpolator = LinearInterpolator()
            duration = 1000
            alpha(1f)
            startDelay = 1000
            start()
        }



        return binding!!.root
    }

}