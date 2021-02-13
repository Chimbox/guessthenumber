package felix.alfonso.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue = 0
    var maxValue = 100
    var num: Int = 0
    var won: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvGuessings: TextView = findViewById(R.id.tvGuessings)
        val btnDown: Button = findViewById(R.id.btnDown)
        val btnUp: Button = findViewById(R.id.btnUp)
        val btnGenerate: Button = findViewById(R.id.btnGenerate);
        val btnGuessed: Button = findViewById(R.id.btnGuessed);



        btnGenerate.setOnClickListener {
            num = Random.nextInt(minValue, maxValue)
            tvGuessings.setText(num.toString())
            btnGenerate.visibility = View.INVISIBLE
            btnGuessed.visibility = View.VISIBLE

        }

        btnUp.setOnClickListener {
            minValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                tvGuessings.setText(num.toString())
            } else {
                tvGuessings.setText("You have won")
            }
        }

        btnDown.setOnClickListener {
            maxValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                tvGuessings.setText(num.toString())
            } else {
                tvGuessings.setText("You have won")
            }
        }

        btnGuessed.setOnClickListener {
            if(!won) {
                tvGuessings.setText("Your number is: "+ num)
                btnGuessed.setText("Play again")
                won=true
            }else{
                btnGenerate.visibility=View.VISIBLE
                btnGuessed.setText("Guessed")
                tvGuessings.setText("Tap on generate to start")
                btnGuessed.visibility=View.GONE
                resetValues()
            }
        }
    }

    fun resetValues(){
        minValue=0
        maxValue=100
        num=0
        won=false
    }

    fun checkingLimits(): Boolean {
        return minValue != maxValue
    }
}