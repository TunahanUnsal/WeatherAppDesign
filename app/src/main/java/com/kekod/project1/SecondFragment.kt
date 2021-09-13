package com.kekod.project1

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    13.09.2021  23:33     │
//  └──────────────────────────┘

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import com.github.matteobattilana.weather.PrecipType
import com.kekod.project1.databinding.FragmentFirstBinding
import com.kekod.project1.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    private var binding: FragmentSecondBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSecondBinding.inflate(inflater, container, false)


        binding!!.weatherView.setWeatherData(PrecipType.RAIN)


        binding!!.cardLinear.alpha = 0.0f
        binding!!.cardLinear.animate().apply {
            interpolator = LinearInterpolator()
            duration = 1000
            alpha(1f)
            startDelay = 1000
            start()
        }
        binding!!.weatherText.alpha = 0.0f
        binding!!.weatherText.animate().apply {
            interpolator = LinearInterpolator()
            duration = 1000
            alpha(1f)
            startDelay = 1000
            start()
        }




        return binding!!.root
    }

}
