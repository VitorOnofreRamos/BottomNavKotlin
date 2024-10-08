package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.activities.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttonHome: ImageButton
    private lateinit var buttonHistory: ImageButton
    private lateinit var buttonTask: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        inicializar()
    }

    private fun inicializar(){
        buttonHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        buttonHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        buttonTask.setOnClickListener {
            val intent = Intent(this, TaskActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        buttonHome = findViewById(R.id.ID1_homeButton)
        buttonHistory = findViewById(R.id.ID2_historyButton)
        buttonTask = findViewById(R.id.ID3_taskButton)
    }
}
