package com.example.randomizerapp

import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList
import kotlin.random.Random.Default.nextBoolean

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawButton = findViewById<Button>(R.id.drawButton)
        val initialText = findViewById<TextView>(R.id.initialText)
        val cardNumberText = findViewById<TextView>(R.id.cardNumberText)
        // val cardSuitText = findViewById<TextView>(R.id.cardSuitText)
        val cardImage = findViewById<ImageView>(R.id.cardImage)
        val suitImage = findViewById<ImageView>(R.id.suitImage)

        val cardImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.empty_playing_card)
        cardImage.setImageBitmap(cardImageBitmap)

        val redCloverImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.red_clover)
        val blackCloverImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.black_clover)
        val redSpadeImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.red_spade)
        val blackSpadeImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.black_spade)
        val redDiamondImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.red_diamond)
        val blackDiamondImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.black_diamond)
        val redHeartImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.red_heart)
        val blackHeartImageBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.black_heart)

        // possible card numbers
        val cardNumbers = ArrayList<String>()
        cardNumbers.add("A")
        cardNumbers.add("2")
        cardNumbers.add("3")
        cardNumbers.add("4")
        cardNumbers.add("5")
        cardNumbers.add("6")
        cardNumbers.add("7")
        cardNumbers.add("8")
        cardNumbers.add("9")
        cardNumbers.add("10")

        // spelled out
        // cardNumbers.add("Jack")
        // cardNumbers.add("Queen")
        // cardNumbers.add("King")

        // first letter
        cardNumbers.add("J")
        cardNumbers.add("Q")
        cardNumbers.add("K")

        // possible card suits
        val cardSuits = ArrayList<Int>()
        cardSuits.add(1) // clover
        cardSuits.add(2) // spade
        cardSuits.add(3) // diamond
        cardSuits.add(4) // heart


        // suitColor: 0 = red, 1 = black
        // suitChoice: 1 = clover, 2 = spade, 3 = diamond, 4 = heart
        drawButton.setOnClickListener {

            // clear initial text
            initialText.text = ""

            // random draw
            var colorChoice = nextBoolean()
            var suitColor = 0
            if (colorChoice == true) {
                cardNumberText.setTextColor(Color.RED)
                // cardSuitText.setTextColor(Color.RED)
            } else {
                cardNumberText.setTextColor(Color.BLACK)
                // cardSuitText.setTextColor(Color.BLACK)
                suitColor = 1
            }

            cardNumberText.bringToFront()
            // cardSuitText.bringToFront()
            suitImage.bringToFront()

            cardNumberText.text = (cardNumbers.random())
            val suitChoice = (1..4).random()
            if (suitColor == 1) {
                when(suitChoice) {
                    1 -> suitImage.setImageBitmap(blackCloverImageBitmap)
                    2 -> suitImage.setImageBitmap(blackSpadeImageBitmap)
                    3 -> suitImage.setImageBitmap(blackDiamondImageBitmap)
                    4 -> suitImage.setImageBitmap(blackHeartImageBitmap)
                }
            } else if (suitColor == 0) {
                when(suitChoice) {
                    1 -> suitImage.setImageBitmap(redCloverImageBitmap)
                    2 -> suitImage.setImageBitmap(redSpadeImageBitmap)
                    3 -> suitImage.setImageBitmap(redDiamondImageBitmap)
                    4 -> suitImage.setImageBitmap(redHeartImageBitmap)
                }
            }
            // cardSuitText.text = (cardSuits.random())
        }
    }
}
