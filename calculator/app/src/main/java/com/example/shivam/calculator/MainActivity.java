package com.example.shivam.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText operand_1, operand_2;
    Button mul,add,sub,div,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hello");
        mul = (Button) findViewById(R.id.multiply);
        add = (Button) findViewById(R.id.addition);
        sub = (Button) findViewById(R.id.subtract);
        div = (Button) findViewById(R.id.divide);
        res = (Button) findViewById(R.id.reset);
        System.out.println("hello");
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiply(view);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hello");
                addition(view);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtract(view);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divide(view);
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset(view);
            }
        });
    }
    public void multiply (View view){
        double op_1 = operand_1fetch();
        double op_2 = operand_2fetch();
        double result = (op_1 * op_2);
        Intent in = new Intent(MainActivity.this,ResultActivity.class);
        in.putExtra("result" , result);
        startActivity(in);
        finish();
    }
    public void addition (View view){
        System.out.println("hello");
        double op_1 = operand_1fetch();
        double op_2 = operand_2fetch();
        System.out.println(op_1);
        System.out.println(op_2);
        double result = (op_1 + op_2);
        Intent in = new Intent(MainActivity.this,ResultActivity.class);
        in.putExtra("result" , result);
        startActivity(in);
        finish();
    }
    public void subtract (View view){
        double op_1 = operand_1fetch();
        double op_2 = operand_2fetch();
        double result = (op_1 - op_2);
        Intent in = new Intent(MainActivity.this,ResultActivity.class);
        in.putExtra("result" , result);
        startActivity(in);
        finish();
    }
    public void divide (View view){
        double op_1 = operand_1fetch();
        double op_2 = operand_2fetch();
        if(op_2==0){Toast.makeText(MainActivity.this,
                "Cannot divide by 0 change it please", Toast.LENGTH_SHORT).show();}
        else{
            double result = (op_1 / op_2);
            Intent in = new Intent(MainActivity.this,ResultActivity.class);
            in.putExtra("result" , result);
            startActivity(in);
            finish();
        }
    }
    public void reset(View view){
        operand_1 = (EditText) findViewById(R.id.operand_1);
        operand_2 = (EditText) findViewById(R.id.operand_2);
        operand_1.setText("");
        operand_2.setText("");
    }
    public double operand_1fetch(){
        operand_1 = (EditText) findViewById(R.id.operand_1);
        String OPS = operand_1.getText().toString();
        double op_1 = 0;
        try {
             op_1 = Double.parseDouble(OPS);
            //return op_1;
        }catch(NumberFormatException e){Toast.makeText(MainActivity.this,
                "Your Entry is wrong", Toast.LENGTH_SHORT).show();}
        return op_1;
    }
    public double operand_2fetch(){
        operand_2 = (EditText) findViewById(R.id.operand_2);
        String OPS = operand_2.getText().toString();
        double op_2 = 0;
        try {
            op_2 = Double.parseDouble(OPS);
        }catch(NumberFormatException e){Toast.makeText(MainActivity.this,
                "Your Entry is wrong", Toast.LENGTH_SHORT).show();}
        return op_2;
    }
}
