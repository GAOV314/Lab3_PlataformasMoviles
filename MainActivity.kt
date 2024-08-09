/**
 * Universidad del Valle de Guatemala
 * Programacion de plataformas moviles
 * Gadiel Ocana, 231270
 * 8/08/2024
 */
package edu.uvg.calculatorlab3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Actividad principal
class MainActivity : AppCompatActivity() {
    var infixExpression = StringBuilder() // Construccion de la expresion a mostrar en la view

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)// Apartir de aca agregar funcionalidad
        // Obtener referencias a los componentes UI
        val expressionTextView = findViewById<TextView>(R.id.expressionTextView)
        val num1Button = findViewById<Button>(R.id.num1Button)
        val num2Button = findViewById<Button>(R.id.num2Button)
        val num3Button = findViewById<Button>(R.id.num3Button)
        val num4Button = findViewById<Button>(R.id.num4Button)
        val num5Button = findViewById<Button>(R.id.num5Button)
        val num6Button = findViewById<Button>(R.id.num6Button)
        val num7Button = findViewById<Button>(R.id.num7Button)
        val num8Button = findViewById<Button>(R.id.num8Button)
        val num9Button = findViewById<Button>(R.id.num9Button)
        val num0Button = findViewById<Button>(R.id.num0Button)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val resultButton = findViewById<Button>(R.id.resultButton)
        val plusButton = findViewById<Button>(R.id.plusButton)
        val subButton = findViewById<Button>(R.id.subButton)
        val multButton = findViewById<Button>(R.id.multButton)
        val divButton = findViewById<Button>(R.id.divButton)
        val powerButton = findViewById<Button>(R.id.powerButton)
        val squareButton = findViewById<Button>(R.id.squareButton)
        val pointButton = findViewById<Button>(R.id.pointButton)
        val openButton = findViewById<Button>(R.id.openButton)
        val closeButton = findViewById<Button>(R.id.closeButton)

        // listeners para escritura de numeros
        num1Button.setOnClickListener{expressionTextView.setText(infixExpression.append("1"))}
        num2Button.setOnClickListener{expressionTextView.setText(infixExpression.append("2"))}
        num3Button.setOnClickListener{expressionTextView.setText(infixExpression.append("3"))}
        num4Button.setOnClickListener{expressionTextView.setText(infixExpression.append("4"))}
        num5Button.setOnClickListener{expressionTextView.setText(infixExpression.append("5"))}
        num6Button.setOnClickListener{expressionTextView.setText(infixExpression.append("6"))}
        num7Button.setOnClickListener{expressionTextView.setText(infixExpression.append("7"))}
        num8Button.setOnClickListener{expressionTextView.setText(infixExpression.append("8"))}
        num9Button.setOnClickListener{expressionTextView.setText(infixExpression.append("9"))}
        num0Button.setOnClickListener{expressionTextView.setText(infixExpression.append("0"))}
        cleanButton.setOnClickListener{
            expressionTextView.setText("0")
            infixExpression.clear()
        }
        // Lisener para calcular la expresion de la vista
        resultButton.setOnClickListener{
            var calculator = Calculator()
            var infixExpression = expressionTextView.text.toString().trim()
            if(!infixExpression.isEmpty()){
                var result: Double = calculator.evaluatePostfix(calculator.infixToPostfix(infixExpression))
                expressionTextView.setText("$result")
            }else{
                expressionTextView.setText("Ingrese una expresion para calcular.") // Si el espacio esta vacio
            }
        }
        // Escritura de signos operativos y parentesis
        plusButton.setOnClickListener{expressionTextView.setText(infixExpression.append("+"))}
        subButton.setOnClickListener{expressionTextView.setText(infixExpression.append("-"))}
        multButton.setOnClickListener{expressionTextView.setText(infixExpression.append("*"))}
        divButton.setOnClickListener{expressionTextView.setText(infixExpression.append("/"))}
        powerButton.setOnClickListener{expressionTextView.setText(infixExpression.append("^"))}
        squareButton.setOnClickListener{expressionTextView.setText(infixExpression.append("√"))}
        pointButton.setOnClickListener{expressionTextView.setText(infixExpression.append("."))}
        openButton.setOnClickListener{expressionTextView.setText(infixExpression.append("("))}
        closeButton.setOnClickListener{expressionTextView.setText(infixExpression.append(")"))}


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }




}