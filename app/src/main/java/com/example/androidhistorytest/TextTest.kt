package com.example.androidhistorytest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TextTest : AppCompatActivity() {

    private var answers = arrayListOf<Int>()
    private lateinit var testText: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var testVar1: RadioButton
    private lateinit var testVar2: RadioButton
    private lateinit var testVar3: RadioButton
    private lateinit var testVar4: RadioButton
    private lateinit var button: Button
    private lateinit var toolbar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_text_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbar = findViewById(R.id.toolbar)
        radioGroup = findViewById(R.id.test)
        testText = findViewById(R.id.testText)
        testVar1 = findViewById(R.id.testVar1)
        testVar2 = findViewById(R.id.testVar2)
        testVar3 = findViewById(R.id.testVar3)
        testVar4 = findViewById(R.id.testVar4)
        button = findViewById(R.id.button)

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

    fun accept(view: View) {
        val id: Int = radioGroup.checkedRadioButtonId
        if (id != -1) {
            val radio: RadioButton = findViewById(id)
            when (radio) {
                testVar1 -> answers.add(1)
                testVar2 -> answers.add(2)
                testVar3 -> answers.add(3)
                testVar4 -> answers.add(4)
            }

            radio.isChecked = false
            when (answers.size) {
                1 -> {
                    testText.setText(R.string.test2Text)
                    testVar1.setText(R.string.test2Var1)
                    testVar2.setText(R.string.test2Var2)
                    testVar3.setText(R.string.test2Var3)
                    testVar4.setText(R.string.test2Var4)
                }

                2 -> {
                    testText.setText(R.string.test3Text)
                    testVar1.setText(R.string.test3Var1)
                    testVar2.setText(R.string.test3Var2)
                    testVar3.setText(R.string.test3Var3)
                    testVar4.setText(R.string.test3Var4)
                }

                3 -> {
                    testText.setText(R.string.test4Text)
                    testVar1.setText(R.string.test4Var1)
                    testVar2.setText(R.string.test4Var2)
                    testVar3.setText(R.string.test4Var3)
                    testVar4.setText(R.string.test4Var4)
                }

                4 -> {
                    testText.setText(R.string.test5Text)
                    testVar1.setText(R.string.test5Var1)
                    testVar2.setText(R.string.test5Var2)
                    testVar3.setText(R.string.test5Var3)
                    testVar4.setText(R.string.test5Var4)
                }

                5 -> {
                    val intent = Intent(this, Answers::class.java)
                    intent.putIntegerArrayListExtra("answers", answers)
                    finish()
                    startActivity(intent)
                }
            }
        }
    }


}