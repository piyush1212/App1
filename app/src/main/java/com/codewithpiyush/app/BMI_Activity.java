package com.codewithpiyush.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText edWeg,edHei;
        TextView txtRes,txtInter,txtDiet;
        Button btnRes,btnReset,register;

        edWeg = (EditText) findViewById(R.id.edweg);
        edHei = (EditText) findViewById(R.id.edhei);

        txtRes = (TextView) findViewById(R.id.txtres);

        btnRes = (Button) findViewById(R.id.btnres);
        btnReset = (Button) findViewById(R.id.btnreset);
        register = (Button) findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(BMI_Activity.this, Fitness_Activity.class);
                startActivity(intent);
            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg = edWeg.getText().toString();
                String strhei = edHei.getText().toString();

                if(strweg.equals("")){
                    edWeg.setError("Please Enter Your Weight");
                    edWeg.requestFocus();
                    return;
                }
                if(strhei.equals("")){
                    edHei.setError("Please Enter Your Height");
                    edHei.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;

                float bmiValue = BMICalculator(weight,height);

                txtRes.setText("BMI = " + bmiValue);

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edHei.setText("");
                edWeg.setText("");

                txtRes.setText("");
            }
        });


    }

    public float BMICalculator(float weight, float height) {
        return weight / (height * height);
    }

    public String interpreteBMI(float bmiValue) {
        if (bmiValue < 16) {
            return "Severely Underweight";
        }
        else if (bmiValue < 18.5) {
            return "Underweight";
        }
        else if (bmiValue < 25) {
            return "Normal";
        }
        else if (bmiValue < 30) {
            return "OverWeight";
        }
        else
            return "Obese";
    }
}
