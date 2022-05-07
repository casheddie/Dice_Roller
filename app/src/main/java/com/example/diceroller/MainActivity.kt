package com.example.diceroller

// imports the necessary libraries.
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// creates reference to Button function by using the findViewById functions
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // roll dice at app start up
        rollDice()
    }

    // defines a private method for rolling the dice
    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // determine which drawable resource is used for each dice roll of diceRoll
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // determine which drawable resource is used for each dice roll of diceRoll2
        val drawableResource2 = when (diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // update the ImageView with the correct drawable resource id
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)


        // update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

    }
}
// creates the Dice class
class Dice(private val numSides: Int) {

    // creates the roll method in the Dice class to perform the dice roll
    fun roll(): Int {
        return (1..numSides).random()
    }
}