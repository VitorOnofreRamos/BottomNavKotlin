package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private var xModel: Int=0;
private var yModel: Int=0;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewX: TextView = findViewById(R.id.ID1_XMod_textView)
        val buttonXUp: Button = findViewById(R.id.ID2_XUp_button)
        val buttonXDown: Button = findViewById(R.id.ID3_XDown_button)

        val viewY: TextView = findViewById(R.id.ID4_YMod_textView)
        val buttonYUp: Button = findViewById(R.id.ID5_YUp_button)
        val buttonYDown: Button = findViewById(R.id.ID6_YDown_button)

        val buttonZ: Button = findViewById(R.id.ID9_Final_button)
        val viewZ: TextView = findViewById(R.id.ID10_Result_textView)

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
}