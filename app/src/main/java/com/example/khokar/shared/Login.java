package com.example.khokar.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv = (TextView) findViewById(R.id.welcome);

        SharedPreferences sp = getSharedPreferences("mubeen", Context.MODE_PRIVATE);
        String nam = sp.getString("U" , "");

         tv.setText("Welcome" + nam);
    }
}
