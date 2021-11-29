package com.codewithpiyush.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignUp_Activity extends AppCompatActivity {

    EditText name,phone,email,pass,passConfirmation;
    Button register;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.et_name);
        phone = (EditText) findViewById(R.id.et_mobile);
        email = (EditText) findViewById(R.id.et_email);
        pass = (EditText) findViewById(R.id.et_password);
        passConfirmation = (EditText) findViewById(R.id.et_confirm_password);
        register = (Button) findViewById(R.id.bt_register);
        textView = (TextView) findViewById(R.id.et_register);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp_Activity.this,SignIn_Activity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();

                Toast.makeText(SignUp_Activity.this, "You have been registered now", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void validation(){
        String mName = name.getText().toString();
        String mPhone = phone.getText().toString();
        String mEmail = email.getText().toString();
        String mPass = pass.getText().toString();
        String mPassCon = passConfirmation.getText().toString();

        if(mName.matches("")){
            Toast.makeText(SignUp_Activity.this, "Enter Name", Toast.LENGTH_LONG).show();
            return;
        }

        if(!mName.matches("[a-zA-Z]+")){
            Toast.makeText(SignUp_Activity.this, "Enter Valid Name", Toast.LENGTH_LONG).show();
            return;
        }

        if(mPhone.matches("")){
            Toast.makeText(SignUp_Activity.this, "Enter Mobile Number", Toast.LENGTH_LONG).show();
            return;
        }

        if(!Patterns.PHONE.matcher(mPhone).matches() || mPhone.length() != 10){
            Toast.makeText(SignUp_Activity.this, "Enter Valid Number", Toast.LENGTH_LONG).show();
            return;
        }

        if(mEmail.matches("")){
            Toast.makeText(SignUp_Activity.this, "Enter Email", Toast.LENGTH_LONG).show();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()){
            Toast.makeText(SignUp_Activity.this, "Enter Valid Email", Toast.LENGTH_LONG).show();
            return;
        }

        if(!mPass.matches(mPassCon)){
            Toast.makeText(SignUp_Activity.this, "Password variation found", Toast.LENGTH_LONG).show();
            return;
        }

    }


}