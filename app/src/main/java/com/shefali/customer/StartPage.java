package com.shefali.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity {
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        login = (Button) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(StartPage.this,
                        Login.class);
                startActivity(myIntent);
            }
        });

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(StartPage.this,
                        SignUp.class);
                startActivity(myIntent);
            }
        });
    }
}
