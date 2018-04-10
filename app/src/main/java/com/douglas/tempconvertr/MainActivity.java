package com.douglas.tempconvertr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener  {

    //declare instance variables for widgets
    private RadioButton trueVal;
    private RadioButton falseVal;
    private TextView textViewFour;
    private TextView textViewOne;
    private String trueOrFalse;
    private int counter = 0;
    private int gameCount = 0;
    private TextView textViewFive;
    private Button button;
    private Button buttonTwo;

    private String questions[] = {"Sacramento is the capital of Cali?", "Chicago is the capital of Illinois?",
    "New york is the capital of New York?", "Tallahassee is the capital of Florida?", "Salem is capital of Oregon?"};
    private String questionsTF[] = {"true", "false", "false", "true", "true"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to widgets via R class
        textViewFour = findViewById(R.id.textViewFour);
        textViewOne = findViewById(R.id.textViewOne);
        textViewFive = findViewById(R.id.textViewFive);
        button = findViewById(R.id.button);
        buttonTwo = findViewById(R.id.button2);
        trueVal = findViewById(R.id.True);
        falseVal = findViewById(R.id.False);
        button.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
    }

    private void trueOrFalse() {
        //get input and determine if true or false
        if (trueVal.isChecked()) {
            trueOrFalse = "true";
        }
        if (falseVal.isChecked()) {
            trueOrFalse = "false";
        }

        if (gameCount == 5) {
            textViewFour.setText("Game Over.");

        } else {

            if (trueOrFalse.equals(questionsTF[gameCount])) {
                textViewFour.setText(questionsTF[gameCount]  + " was last answer.");
                textViewFive.setText(questions[gameCount]);
                gameCount++;
                textViewOne.setText("Games won: " + Integer.toString(counter) + " out of 5.");
                counter++;

            } else {
                textViewFour.setText(trueOrFalse  + " was last answer.");
                textViewFive.setText(questions[gameCount]);
                textViewOne.setText("Games won: " + Integer.toString(counter) + " out of 5.");
                gameCount++;
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button:
                trueOrFalse();
                trueVal.setChecked(false);
                falseVal.setChecked(false);
                break;

            case R.id.button2:
                this.recreate();
                break;

            default:
                trueOrFalse();
                break;
        }
    }
    }