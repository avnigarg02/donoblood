package com.example.donoblood20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        //TextView emailSignUp = (TextView) findViewById(R.id.emailSignUp);
        TextView password = (TextView) findViewById(R.id.password);
        TextView passwordConfirmation = (TextView) findViewById(R.id.passwordConfirmation);


        MaterialButton signUpBtn = (MaterialButton) findViewById(R.id.signUpBtn);

        //admin@gmail.com and admin
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(passwordConfirmation.getText().toString())){
                    //correct
                    Toast.makeText(Activity2.this, "SIGN UP SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    openActivity3();
                } else {
                    //incorect
                    Toast.makeText(Activity2.this, "SIGN UP FAIL Check Password Confirmation", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}