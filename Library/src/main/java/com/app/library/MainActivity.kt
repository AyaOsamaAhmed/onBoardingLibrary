package com.app.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.app.library.databinding.ActivityMainBinding
import com.app.onboardinglibrary.AdapterOnBoarding
import com.app.onboardinglibrary.OnBoarding
import io.github.vejei.viewpagerindicator.indicator.CircleIndicator
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val demoList = ArrayList<OnBoarding>()
    var size = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViewPager(setOnBoardingData())
        //enableNextButton()

        binding.nextButton.setOnClickListener {
            nextPosition()
        }

    }

    private fun initViewPager(list: ArrayList<OnBoarding>) {
        val adapter = AdapterOnBoarding(list)
        binding.adapterOnBoarding = adapter

        binding.dotsIndicator.setWithViewPager2(binding.viewPager, false)
        binding.dotsIndicator.itemCount = list.size
        binding.dotsIndicator.setAnimationMode(CircleIndicator.AnimationMode.SLIDE)

    }

    private fun onBoardData(item : OnBoarding){
        demoList.add(
           item
        )

    }


    private fun setOnBoardingData(): ArrayList<OnBoarding> {

        demoList.add(
            OnBoarding(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam",
                R.drawable.ic_launcher_background
            )
        )
        demoList.add(
            OnBoarding(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam",
                R.drawable.ic_launcher_background
            )
        )
        demoList.add(
            OnBoarding(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam",
                R.drawable.ic_launcher_background
            )
        )
        demoList.add(
            OnBoarding(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam",
                R.drawable.ic_launcher_background
            )
        )

        return demoList
    }

    private fun enableNextButton() {
        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == setOnBoardingData().size - 1) {
                    binding.skip.visibility = View.GONE
                    binding.nextButton.visibility = View.VISIBLE
                } else {
                    binding.skip.visibility = View.VISIBLE
                    binding.nextButton.visibility = View.GONE
                }
            }
        })
    }

    fun nextPosition(){
       size = demoList.size
        binding.apply{
            val position = viewPager.currentItem
            if ((position+1) == size){


            }else{

                when (position) {
                    0 -> {
                        viewPager.currentItem +=1
                    }
                    1 -> {
                        viewPager.currentItem +=1
                    }
                    else -> {

                    }
                }


            }
        }

    }
    fun onClickNext(){
      //  getSharedPrefInstance().setValue(Constants.IS_WIZARD , true)
      //  checkToMain(activity)
    }

    fun skip(){
       // getSharedPrefInstance().setValue(Constants.IS_WIZARD , true)
       // checkToMain(activity)
    }

}