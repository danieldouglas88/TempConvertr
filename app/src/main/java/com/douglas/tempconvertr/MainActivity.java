package com.douglas.tempconvertr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    //declare instance variables for widgets

    private EditText editTextOne;
    private TextView textViewFour;
    private String fahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference to widgets via R class
        editTextOne = findViewById(R.id.editTextOne);
        textViewFour = findViewById(R.id.textViewFour);
        editTextOne.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        fahrenheitToCelsius();
        return false;
    }

    private void fahrenheitToCelsius() {
        //get input and calculate
        fahrenheit = editTextOne.getText().toString();
        float fToC = (Float.parseFloat(fahrenheit) - 32) * 5/9;
        String str = String.valueOf(fToC);
        textViewFour.setText(str);
    }

    public String returnVal() {
            //get input and calculate
        fahrenheit = editTextOne.getText().toString();
            float fToC = (Float.parseFloat(fahrenheit) - 32) * 5/9;
            String str = String.valueOf(fToC);
            textViewFour.setText(str);

        return str;
        }

    @Override
    protected void onPause(){
        super.onPause();
        textViewFour.setText(returnVal());
        editTextOne.setText(returnVal());
    }
    @Override
    protected void onResume(){
        super.onResume();
        textViewFour.setText(returnVal());
        editTextOne.setText(returnVal());
    }
}