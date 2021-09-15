package com.lazarovstudio.rpsrockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lazarovstudio.rpsrockpaperscissors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnPlayTwo.visibility = View.GONE
        binding.resetGame.setOnClickListener { resetBtn() }
    }

    private fun resetBtn() {
        binding.rpsImgOne.setImageResource(0)
        binding.rpsImgTwo.setImageResource(0)
        binding.txtResult.text = "Reset"
        binding.btnPlayOne.visibility = View.VISIBLE
        binding.btnPlayTwo.visibility = View.INVISIBLE
    }

    fun result(r:String){
        binding.txtResult.text = r
        binding.resetGame.isEnabled = true
    }

    fun btnOne(view: android.view.View) {
        binding.btnPlayOne.visibility = View.INVISIBLE

        val playerGame = Player()
        val rndImgOne: Int = playerGame.playerOne()
        binding.rpsImgOne.setImageResource(rndImgOne)
        binding.btnPlayTwo.visibility = View.VISIBLE
    }

    fun btnTwo(view: android.view.View){
        binding.btnPlayTwo.visibility = View.INVISIBLE

        val playerGame = Player()
        val rndImgOne: Int = playerGame.playerTwo()
        binding.rpsImgTwo.setImageResource(rndImgOne)
        binding.btnPlayOne.visibility = View.INVISIBLE

        val result = playerGame.gameViewResult()
        result(result)
    }
}


