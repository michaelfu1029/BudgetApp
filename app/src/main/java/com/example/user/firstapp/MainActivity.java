package com.example.user.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TOTAL_COUNT = "total_count";
    private double amountLeft;

    public void switchAct(View view) {
        Intent secondPage = new Intent(this, SecondActivity.class);
        startActivity(secondPage);
    }

    public void subtract(View view, double value) {
        amountLeft -= value;
        setValue(amountLeft);
    }

    public void setValue(double set) {
        // Get the text view.
        TextView showCountTextView = (TextView)findViewById(R.id.textView);
        amountLeft = set;
        // Display the new value in the text view.
        showCountTextView.setText(Double.toString(amountLeft));
    }

    public  void addOne(View view) {
        int addVal = 1;
        countMe(view, addVal);
    }
    public  void addFive(View view) {
        int addVal = 5;
        countMe(view, addVal);
    }

    public void countMe (View view, int addVal) {
        // Get the text view.
        TextView showCountTextView = (TextView)
                findViewById(R.id.textView);

        // Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        // Convert value to a number and increment it.
        Integer count = Integer.parseInt(countString);
        count += addVal;

        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }

    public  void reset(View view) {
        TextView showCountTextView = (TextView)
                findViewById(R.id.textView);

        // Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        // Convert value to a number and increment it.
        Integer count = Integer.parseInt(countString);
        count = 0;

        // Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }

    public void subFromTotal(View view){

        TextView showCountTextView = (TextView)
                findViewById(R.id.textView);

        // Get the value of the text view.
        String countString = showCountTextView.getText().toString();

        // Convert value to a number and increment it.
        Integer cost = Integer.parseInt(countString);

        // Display the new value in the text view.
        showCountTextView.setText(cost.toString());

        TextView showSumTextView = (TextView)
                findViewById(R.id.totalSum);

        // Get the value of the text view.
        String sumString = showSumTextView.getText().toString();

        // Convert value to a number and increment it.
        double sum = Double.parseDouble(sumString);

        if(sum >= cost) {
            sum -= cost;
            // Display the new value in the text view.
            showSumTextView.setText(Double.toString(sum));

            // Toast myToast = Toast.makeText(this, message, duration);
            Toast myToast = Toast.makeText(this, "Budget Updated",
                    Toast.LENGTH_SHORT);
            myToast.show();
        } else {
            Toast myToast = Toast.makeText(this, "Insufficient funds, do not buy it",
                    Toast.LENGTH_SHORT);
            myToast.show();
        }
        reset(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
