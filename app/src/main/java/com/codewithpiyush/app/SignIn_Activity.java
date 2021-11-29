package com.codewithpiyush.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn_Activity extends AppCompatActivity {
    TextView textView;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        textView = (TextView) findViewById(R.id.textLogin);
        login = (Button) findViewById(R.id.btnRegister);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),BMI_Activity.class));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn_Activity.this,SignUp_Activity.class);
                startActivity(intent);
            }
        });


    }
}
