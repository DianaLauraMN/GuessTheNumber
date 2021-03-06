package medina.diana.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var maxvalue=100
    var minValue=0
    var num:Int=0
    var won=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView=findViewById(R.id.guessings)
        val down: Button= findViewById(R.id.down)
        val up: Button=findViewById(R.id.up)
        val generate: Button=findViewById(R.id.generate)
        val guessed:Button=findViewById(R.id.guessed)

        generate.setOnClickListener{
            num= Random.nextInt(minValue,maxvalue)
            guessings.setText(num.toString())
            generate.visibility= View.INVISIBLE
            guessed.visibility=View.VISIBLE

        }

        up.setOnClickListener{
            minValue=num
            if (checkingLimits()){
                num= Random.nextInt(minValue,maxvalue)
                guessings.setText(num.toString())
            }else{
                guessings.setText("No puede ser :c me ganaste")
            }

        }
        down.setOnClickListener{
            minValue=num
            if (checkingLimits()){
                num= Random.nextInt(minValue,maxvalue)
                guessings.setText(num.toString())
            }else{
                guessings.setText("No puede ser :c me ganaste")
            }
        }
        guessed.setOnClickListener{
            if (!won){
                guessings.setText("Adiviné, tu número es el "+num)
                guessed.setText("Play again")
            }else{
                generate.visibility=View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.setText("Guessed")
                guessed.visibility=View.GONE
                resetValue()
            }

        }

    }

    fun resetValue(){
        var maxvalue=100
        var minValue=0
        var num:Int=0
        var won=false
    }

    fun checkingLimits():Boolean{
        return minValue!=maxvalue
    }
}