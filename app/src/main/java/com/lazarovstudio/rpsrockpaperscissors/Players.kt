package com.lazarovstudio.rpsrockpaperscissors

import android.util.Log

class Player{
    private var userFirst: Int? = null
    private var userSecond: Int? = null

    var log = Log.d("userFirst", "$userFirst")
    var log2 = Log.d("userSecond", "$userSecond")

    private fun randomCard(): Int {
        val playerGame = RspGame(3)
        val resultOne = when (playerGame.play()) {
            1 -> R.drawable.nosh_removebg_preview
            2 -> R.drawable.pepper_copy_removebg_preview
            else -> R.drawable.rock_removebg_preview
        }
        return resultOne
    }

    fun playerOne(): Int {
        userFirst = randomCard()
        return userFirst as Int
    }

    fun playerTwo(): Int {
        userSecond = randomCard()
        return userSecond as Int
    }

    fun gameViewResult(): String {
        Log.d("IDOne","$userFirst")
        Log.d("IDTwo","$userSecond")
        return if (userFirst == userSecond) "Ничья"
        else if (
            (userFirst == R.drawable.nosh_removebg_preview && userSecond == R.drawable.pepper_copy_removebg_preview) ||
            (userFirst == R.drawable.rock_removebg_preview && userSecond == R.drawable.nosh_removebg_preview) ||
            (userFirst == R.drawable.pepper_copy_removebg_preview && userSecond == R.drawable.rock_removebg_preview)
        ) "первый игрок Выйграл!"
        else "второй игрок Выйграл!"
    }
}

class RspGame(private val rps: Int) {
    fun play(): Int {
        return (1..rps).random()
    }
}