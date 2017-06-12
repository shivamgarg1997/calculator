package com.example.shivam.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent in = getIntent();
        double result = in.getExtras().getDouble("result");
        TextView textView = (TextView) findViewById(R.id.textresult);
        String test = String.valueOf(result);
        textView.setText(test);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ResultActivity.this,
                        "Going Back", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}
