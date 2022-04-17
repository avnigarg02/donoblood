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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView email = (TextView) findViewById(R.id.email);
        TextView password = (TextView) findViewById(R.id.password);


        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin@gmail.com and admin
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin")) {
                    //correct
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    openActivity3();
                } else {
                    //incorect
                    Toast.makeText(MainActivity.this, "LOGIN FAIL", Toast.LENGTH_SHORT).show();
                }
            }
        });
        MaterialButton signUpBtn = (MaterialButton) findViewById(R.id.signUpBtn);

        //sign up
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    openActivity2();
            }
        });
    }
        public void openActivity2(){
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }
        public void openActivity3(){
            Intent intent = new Intent(this, Activity3.class);
            startActivity(intent);
    }
    }