package com.douglas.tempconvertr;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, OnClickListener  {

    // define the SharedPreferences object
    private SharedPreferences savedValues;

    // define instance variables that should be saved
    private String billAmountString = "";

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

        // get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues",MODE_PRIVATE);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        fahrenheitToCelsius();
        return false;
    }

    private void fahrenheitToCelsius() {
        //get input and calculate
        fahrenheit = editTextOne.getText().toString();
        float fToC = (Float.parseFloat(fahrenheit) - 32) * 5 / 9;
        String str = String.valueOf(fToC);
        textViewFour.setText(str);
    }

    @Override
    public void onPause() {
        // save the instance variables
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putString("billAmountString", billAmountString);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        // get the instance variables
        billAmountString = savedValues.getString("billAmountString", "");

        // set the bill amount on its widget
        textViewFour.setText(billAmountString);

        // calculate and display
        fahrenheitToCelsius();
    }

    @Override
    public void onClick(View v) {
      fahrenheitToCelsius();
    }

}