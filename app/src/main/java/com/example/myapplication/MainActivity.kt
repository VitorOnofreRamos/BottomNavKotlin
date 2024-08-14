package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var viewX: TextView
    private lateinit var buttonXUp: Button
    private lateinit var buttonXDown: Button

    private lateinit var viewY: TextView
    private lateinit var buttonYUp: Button
    private lateinit var buttonYDown: Button

    private lateinit var buttonZ: Button
    private lateinit var viewZ: TextView

    private var xModel = 0
    private var yModel = 0

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

    fun inicializar(){
        buttonXUp.setOnClickListener {
            xModel += 1
            viewX.text = "Valor X = $xModel"
        }

        buttonXDown.setOnClickListener {
            xModel -= 1
            viewX.text = "Valor X = $xModel"
        }

        buttonYUp.setOnClickListener {
            yModel += 1
            viewY.text = "Valor Y = $yModel"
        }

        buttonYDown.setOnClickListener {
            yModel -= 1
            viewY.text = "Valor Y = $yModel"
        }

        buttonZ.setOnClickListener {
            val equacao1Correta = 2 * xModel + 3 * yModel == 37
            val equacao2Correta = xModel - yModel == -4

            when {
                equacao1Correta && equacao2Correta -> viewZ.text = "Sucesso"
                equacao1Correta || equacao2Correta -> viewZ.text = "Sucesso Parcial"
                else -> viewZ.text = "Insucesso"
            }
        }
    }

    private fun initViews() {
        viewX = findViewById(R.id.ID1_XMod_textView)
        buttonXUp = findViewById(R.id.ID2_XUp_button)
        buttonXDown = findViewById(R.id.ID3_XDown_button)

        viewY = findViewById(R.id.ID4_YMod_textView)
        buttonYUp = findViewById(R.id.ID5_YUp_button)
        buttonYDown = findViewById(R.id.ID6_YDown_button)

        buttonZ = findViewById(R.id.ID9_Final_button)
        viewZ = findViewById(R.id.ID10_Result_textView)
    }
}
