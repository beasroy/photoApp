package com.example.photoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image: ImageView
    var places = arrayOf("Monestry","Pelling","Darjeeling","kursheong","Changu Lake")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tvName)
        next.setOnClickListener {
            updateImageAlpha(currentImage, 0f) // Hide current image
            currentImage = (currentImage + 1) % 5
            updateImageAlpha(currentImage, 1f) // Show next image
            placeName.text=places[currentImage]
        }

        prev.setOnClickListener {
            updateImageAlpha(currentImage, 0f) // Hide current image
            currentImage = (5 + currentImage - 1) % 5
            updateImageAlpha(currentImage, 1f) // Show previous image
            placeName.text=places[currentImage]
        }
    }

    private fun updateImageAlpha(imageNumber: Int, alpha: Float) {
        val idImageToShowString = "pic$imageNumber"
        val idImageToShowInt = resources.getIdentifier(idImageToShowString, "id", packageName)
        image = findViewById(idImageToShowInt)
        image.alpha = alpha
    }


    }
