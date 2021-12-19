package com.example.zalik

import android.app.ActionBar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StartSize()
        val Img : ImageView = findViewById(R.id.MainImg)
        val params: ViewGroup.LayoutParams = Img.layoutParams as ViewGroup.LayoutParams
        val PlsBtn : FloatingActionButton = findViewById(R.id.MainBtnPlus)
        val MinBtn : FloatingActionButton = findViewById(R.id.MainBtnMinus)
        val intent = Intent(this, SecondActivity::class.java)

        PlsBtn.setOnClickListener {
            var tempChange = rand()

            if (Img.height + tempChange >= 700){
                MaxSize()
            }else{
                params.width = Img.width + tempChange
                params.height = Img.height + tempChange
                Img.layoutParams = params
            }

        }
        MinBtn.setOnClickListener {
            var tempChange = rand()

            if (Img.height - tempChange <= 100){
                MinSize()
            }else{
                params.width = Img.width - tempChange
                params.height = Img.height - tempChange
                Img.layoutParams = params
            }
        }

        Img.setOnClickListener{
            intent.putExtra(SecondActivity.Size,Img.height)
            startActivity(intent)
        }

    }
    // Встановлює максимальний розмір для зображення 700х700
    fun MaxSize(){
        val Img : ImageView = findViewById(R.id.MainImg)
        val params: ViewGroup.LayoutParams = Img.layoutParams as ViewGroup.LayoutParams
        params.width = 700
        params.height = 700
        Img.layoutParams = params
    }
    // Встановлює мінимальний розмір для зображення 100х100
    fun MinSize(){
        val Img : ImageView = findViewById(R.id.MainImg)
        val params: ViewGroup.LayoutParams = Img.layoutParams as ViewGroup.LayoutParams
        params.width = 100
        params.height = 100
        Img.layoutParams = params
    }
    // Генерує випадкове число для зміни розміру зображення (10..30)
    fun rand(): Int {
        var change = (10..30).random()
        return change
    }
    // Генерує випадкове значення для зображенн при старті (100..700)
    fun StartSize(){
        val Screen = (100..700).random()
        val Img : ImageView = findViewById(R.id.MainImg)
        val params: ViewGroup.LayoutParams = Img.layoutParams as ViewGroup.LayoutParams
        params.width = Screen
        params.height = Screen
    }
}