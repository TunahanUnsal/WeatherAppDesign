package com.kekod.project1

//          Code with 🥂
//  ┌──────────────────────────┐
//  │ Created by Tuna UNSAL    │
//  │ ──────────────────────── │
//  │ tuna.maeglini@gmail.com  │            
//  │ ──────────────────────── │
//  │    13.09.2021  23:33     │
//  └──────────────────────────┘

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.view.MotionEventCompat
import androidx.fragment.app.Fragment
import com.github.matteobattilana.weather.PrecipType
import com.kekod.project1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var fragment1 : Fragment
    private lateinit var fragment2 : Fragment
    private lateinit var fragment3 : Fragment


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        fragment1 = FirstFragment()
        fragment2 = SecondFragment()
        fragment3 = ThirdFragment()


        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment1).commit()


        hideNavigationBar()


        binding.generalView.setOnTouchListener(object : OnSwipeTouchListener(applicationContext) {

            override fun onSwipeTop() {
                super.onSwipeTop()
            }


            override fun onSwipeBottom() {
                super.onSwipeBottom()
            }

            override fun onSwipeLeft() {

                if (fragment1.isVisible){
                    replaceFragment_right(fragment2)
                }
                else if(fragment2.isVisible){
                    replaceFragment_right(fragment3)
                }



                super.onSwipeLeft()
            }

            override fun onSwipeRight() {

                if (fragment2.isVisible){
                    replaceFragment_left(fragment1)
                }
                else if(fragment3.isVisible){
                    replaceFragment_left(fragment2)
                }


                super.onSwipeRight()
            }
        })



    }

    fun hideNavigationBar() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }

    private fun replaceFragment_left(fragment: Fragment) {


            supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right,
                R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container_view, fragment).commit()



    }
    private fun replaceFragment_right(fragment: Fragment) {

            supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left,
                R.anim.enter_left_to_right, R.anim.exit_left_to_right).replace(R.id.fragment_container_view, fragment).commit()


    }

}
