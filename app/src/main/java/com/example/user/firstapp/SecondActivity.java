package com.example.user.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private static final String SEND_BACK = "send_back";
    private EditText amountSpent;
    private Button submit;
    private double submittedValue;

    public void switchback(View view) {
        Intent firstPage = new Intent(this, MainActivity.class);
        firstPage.putExtra(SEND_BACK,submittedValue);
        startActivity(firstPage);
    }

    public void getValue() {
        String spent = amountSpent.getText().toString();
        submittedValue = Double.parseDouble(spent);
    }
    public void submitButton(View view) {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        amountSpent = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
            }
        });

    }
}
