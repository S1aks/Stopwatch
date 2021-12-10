package com.gb.stopwatch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.stopwatch.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        mainViewModel.liveData1.observe(this, {renderData1(it)})
        mainViewModel.liveData2.observe(this, {renderData2(it)})
        mainViewModel.init()
    }

    private fun renderData1(time: String) {
        binding.text1Time.text = time
    }

    private fun renderData2(time: String) {
        binding.text2Time.text = time
    }

    private fun initView() {
        binding.button1Start.setOnClickListener { mainViewModel.start1() }
        binding.button1Pause.setOnClickListener { mainViewModel.pause1() }
        binding.button1Stop.setOnClickListener { mainViewModel.stop1() }
        binding.button2Start.setOnClickListener { mainViewModel.start2() }
        binding.button2Pause.setOnClickListener { mainViewModel.pause2() }
        binding.button2Stop.setOnClickListener { mainViewModel.stop2() }
    }
}