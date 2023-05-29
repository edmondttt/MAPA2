//video link = https://youtu.be/W9bFKxM5shE

package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // TextView to reference
    private TextView calculatorView
;
    private TextView lowerTextView;

    // Buttons to reference
    Button  button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonMulti,
            buttonDiv, buttonC, buttonEqual, buttonAdvanced;

    // Calculator instance
    private Calculator calculator = new Calculator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextViews set to its reference
        calculatorView
 = (TextView) findViewById(R.id.textView);
        lowerTextView =(TextView) findViewById(R.id.textView2);

        // Buttons set to its reference
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonMinus);
        buttonMulti = (Button) findViewById(R.id.buttonTime);
        buttonDiv = (Button) findViewById(R.id.buttonDivide);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonAdvanced = (Button) findViewById(R.id.buttonAdvanced);

        // Setting Event listeners
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("0");
                calculatorView.append("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("1");
                calculatorView.append("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("2");
                calculatorView.append("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("3");
                calculatorView.append("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("4");
                calculatorView.append("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("5");
                calculatorView.append("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("6");
                calculatorView.append("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("7");
                calculatorView.append("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("8");
                calculatorView.append("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("9");
                calculatorView.append("9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("+");
                calculatorView.append("+");
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("-");
                calculatorView.append("-");
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("*");
                calculatorView.append("*");
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.push("/");
                calculatorView.append("/");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.clear();
                calculatorView.setText("");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String output = calculator.evaluateExpression();
                calculator.push("=");
                if(output != "failed") {
                    calculatorView.append("=" + output);
                    // if the button advanced is STANDARD that means to store history
                    if(buttonAdvanced.getText().toString().equals("STANDARD")) {
                        lowerTextView.append(calculatorView.getText().toString() + "\n");
                    }
                }
                else {
                    calculatorView.append("= Invalid Expression");
                    if(buttonAdvanced.getText().toString().equals("STANDARD")) {
                        lowerTextView.append(calculatorView.getText().toString() + "\n");
                    }
                }
            }
        });

        buttonAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonAdvanced.getText().toString().equals("ADVANCE - WITH HISTORY")) {
                    buttonAdvanced.setText("STANDARD");
                }
                else {
                    buttonAdvanced.setText("ADVANCE - WITH HISTORY");
                    lowerTextView.setText("");
                }
            }
        });

    }
}