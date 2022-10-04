package com.example.diceroller;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.button);
        rollButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rollDice();
                    }
                }
        );

        // Do a dice roll when the app starts
        rollDice();
    }

    private void rollDice() {
        // Create new Dice object with 6 sides and roll it
        Dice dice = new Dice(6);
        int diceRoll = dice.roll();

        // Find the ImageView in the layout
        ImageView diceImage = findViewById(R.id.imageView);

        // Determine which drawable resources ID to use based on the dice roll
        int drawableResources;
        switch (diceRoll) {
            case 1: drawableResources = R.drawable.dice_1;
                    break;
            case 2: drawableResources = R.drawable.dice_2;
                    break;
            case 3: drawableResources = R.drawable.dice_3;
                    break;
            case 4: drawableResources = R.drawable.dice_4;
                    break;
            case 5: drawableResources = R.drawable.dice_5;
                    break;
            default: drawableResources = R.drawable.dice_6;
                    break;
        }

        // Update the ImageView with the correct drawable resources ID
        diceImage.setImageResource(drawableResources);

        // Update the content description
        diceImage.setContentDescription(String.valueOf(diceRoll));
    }
}

class Dice {
    int numSides;

    public Dice(int numSides) {
        this.numSides = numSides;
    }

    int roll() {
        return (int) (Math.random() * 6 + 1);
    }
}
