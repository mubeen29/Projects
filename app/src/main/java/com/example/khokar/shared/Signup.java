package com.example.khokar.shared;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Database db = new Database(this);
        Intent toMain = new Intent(Signup.this, MainActivity.class);

        EditText user = (EditText) findViewById(R.id.username);
        EditText pass = (EditText) findViewById(R.id.password);

        String userValue = user.getText().toString();
        String passValue = pass.getText().toString();
        int charUserLength = userValue.length();
        int charPassLength = passValue.length();

        if (userValue.equals("") && passValue.equals("")) {
            Toast.makeText(Signup.this, "Fields Empty", Toast.LENGTH_SHORT).show();
        }
        else if (charUserLength <= 5 && charPassLength <= 5) {
            Toast.makeText(Signup.this, "Characters too short", Toast.LENGTH_SHORT).show();
        }
        else {
            db.addUsers(new Users(userValue, passValue));
            Toast.makeText(getApplicationContext(),"Registored",Toast.LENGTH_LONG).show();
            startActivity(toMain);
        }

    }
}
