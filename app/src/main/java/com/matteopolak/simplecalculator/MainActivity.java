package com.matteopolak.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private enum Operator {
        NONE,
        ADD,
        MINUS,
        MULTIPLY,
        DIVIDE,
    }

    private double lhs = 0;
    private double rhs = 0;
    private Operator op = Operator.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClickNumber(View view) {
        int id = view.getId();
        Button button = findViewById(id);

        EditText text = findViewById(R.id.resultEdit);
        text.setText(text.getText() + button.getText().toString());
    }

    public void buttonClickAdd(View view) {
        EditText text = findViewById(R.id.resultEdit);

        this.op = Operator.ADD;
        this.lhs = Double.parseDouble(text.getText().toString());

        text.setText("");
    }

    public void buttonClickClear(View view) {
        EditText text = findViewById(R.id.resultEdit);
        text.setText("");
    }

    public void buttonClickDot(View view) {
        EditText text = findViewById(R.id.resultEdit);
        text.setText(text.getText() + ".");
    }

    public void buttonClickMinus(View view) {
        EditText text = findViewById(R.id.resultEdit);

        this.op = Operator.MINUS;
        this.lhs = Double.parseDouble(text.getText().toString());

        text.setText("");
    }

    public void buttonClickDivide(View view) {
        EditText text = findViewById(R.id.resultEdit);

        this.op = Operator.DIVIDE;
        this.lhs = Double.parseDouble(text.getText().toString());

        text.setText("");
    }

    public void buttonClickMultiply(View view) {
        EditText text = findViewById(R.id.resultEdit);

        this.op = Operator.MULTIPLY;
        this.lhs = Double.parseDouble(text.getText().toString());

        text.setText("");
    }

    public void buttonClickResult(View view) {
        if (op != Operator.NONE) {
            EditText text = findViewById(R.id.resultEdit);

            this.rhs = Double.parseDouble(text.getText().toString());

            double result = 0;

            if (op == Operator.ADD) {
                result = this.lhs + this.rhs;
            } else if (op == Operator.MINUS) {
                result = this.lhs - this.rhs;
            } else if (op == Operator.MULTIPLY) {
                result = this.lhs * this.rhs;
            } else if (op == Operator.DIVIDE) {
                result = this.lhs / this.rhs;
            }

            this.op = Operator.NONE;
            this.lhs = result;

            if (result - (int) result != 0) {
                text.setText(String.valueOf(result));
            } else {
                text.setText(String.valueOf((int) result));
            }
        }
    }
}