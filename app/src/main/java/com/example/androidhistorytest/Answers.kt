package com.example.androidhistorytest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.LayoutInflaterCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.forEach

class Answers : AppCompatActivity() {

    private var answersTrue = arrayListOf(1, 4, 4, 1, 3)
    private var answers = arrayListOf<Int>()
    private lateinit var score:TextView
    private lateinit var toolbar:Toolbar

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_answers)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbar = findViewById(R.id.toolbar)
        score = findViewById(R.id.score)
        answers = intent.getIntegerArrayListExtra("answers")!!
        var summ = 0
        for(i in answers.indices){
            if (answersTrue[i]==answers[i]){
                summ+=100
            }
        }
        score.text = "Вы набрали $summ баллов"

        setSupportActionBar(toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.exit ->{
                finish()
            }
        }
        return true
    }

    fun toMain(view: View) {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}