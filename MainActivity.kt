package edu.uvg.calculatorlab3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)// Apartir de aca agregar funcionalidad

        val expressionEditText = findViewById<EditText>(R.id.expressionEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener{

            var calculator = Calculator()
            var infixExpression = expressionEditText.text.toString().trim()
            if(infixExpression == null || (infixExpression.any{it in 'a'..'z' || it in 'A'..'Z'})){

                resultTextView.setText("Ingrese una expresion para calcular.")

            }else{


                var result: Double = calculator.evaluatePostfix(calculator.infixToPostfix(infixExpression))
                resultTextView.setText("$result")
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }




}